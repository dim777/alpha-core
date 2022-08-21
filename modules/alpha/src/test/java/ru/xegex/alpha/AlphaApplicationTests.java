package ru.xegex.alpha;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.xegex.alpha.ex.AlphaEx;
import ru.xegex.alpha.model.Security;
import ru.xegex.alpha.model.Tick;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
public class AlphaApplicationTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlphaApplicationTests.class);
    private static final ClassLoader CLASS_LOADER = AlphaApplicationTests.class.getClassLoader();
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private static final String TICKS_DIRECTORY = "ticks";
    private static Map<Security, List<Tick>> TICKS_DATA = new ConcurrentHashMap<>();

    private ExecutorService executor = Executors.newFixedThreadPool(10);

    @Autowired
    private TickRepository tickRepository;

    @Before
    public void init() throws URISyntaxException {
        URL url = Optional.ofNullable(CLASS_LOADER.getResource(TICKS_DIRECTORY))
                .orElseThrow(() -> new AlphaEx(TICKS_DIRECTORY + " is not exists"));

        File dir = new File(url.toURI());

        if (!dir.isDirectory()) throw new AlphaEx(TICKS_DIRECTORY + " is not ticks directory.");

        List<File> files = Arrays.asList(Optional.ofNullable(dir.listFiles())
                .orElseThrow(() -> new AlphaEx(TICKS_DIRECTORY + " doesn't contain files to import.")));

        files.stream()
                .filter(f -> !f.isDirectory())
                .forEach(f -> {
                    try {
                        TicksProcessorTask ticksProcessorTask = new TicksProcessorTask(new BufferedInputStream(new FileInputStream(f)));
                        TICKS_DATA.putAll(executor.submit(ticksProcessorTask).get());
                    } catch (FileNotFoundException e) {
                        throw new AlphaEx(TICKS_DIRECTORY + " doesn't contain specified file = " + f.getName());
                    } catch (InterruptedException | ExecutionException e) {
                        throw new AlphaEx("Error while processing ticks, ex = " + executor.toString());
                    }
                });
    }

//    private void saveTicks(URL url) throws IOException {
//        File file = new File(url.getFile());
//        Stream<String> lines = Files.readAllLines(file.toPath(), Charset.forName("UTF-8"))
//                .stream()
//                .skip(1);
//
//        List<Tick> ticks = lines.map(this::mapTick)
//                .collect(Collectors.toList());
//
//        tickRepository.saveAll(ticks);
//    }

    @Test
    public void test0() {
        Assert.assertEquals(2, TICKS_DATA.size());
        LOGGER.info("test0");
    }

    class TicksProcessorTask implements Callable<Map<Security, List<Tick>>> {
        private BufferedInputStream bis;

        public TicksProcessorTask(BufferedInputStream bis) {
            this.bis = bis;
        }

        @Override
        public Map<Security, List<Tick>> call() {
            InputStreamReader isr = new InputStreamReader(bis, Charset.forName("UTF-8"));
            Stream<String> lines = new BufferedReader(isr).lines().skip(1);

            return lines.map(this::mapTick)
                    .collect(groupingBy(Tick::getSecurity));
        }

        private Tick mapTick(String s) {
            String[] res = s.split(",");
            LocalDateTime ldt = LocalDateTime.parse(res[2] + res[3], DTF);

            Security securityDTO = new Security();
            securityDTO.setName(res[0]);

            Tick tick = new Tick();
            tick.setId(UUID.randomUUID());
            tick.setSecurity(securityDTO);
            tick.setDateTime(ldt);
            tick.setLast(Double.parseDouble(res[4]));
            tick.setVolume(Integer.parseInt(res[5]));

            return tick;
        }
    }
}


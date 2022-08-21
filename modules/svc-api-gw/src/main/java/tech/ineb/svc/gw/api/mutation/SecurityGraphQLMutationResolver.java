package tech.ineb.svc.gw.api.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.ineb.lib.common.models.Security;

@Service @Slf4j
public class SecurityGraphQLMutationResolver implements GraphQLMutationResolver {
  public Security createSecurity(String title, String text, String category) {
    return postDao.savePost(title, text, category);
  }
}

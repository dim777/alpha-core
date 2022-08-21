package tech.ineb.ats.alpha.market.message;

/**
 * Message interface
 *
 * @param <T>
 * @author dim777
 */
public interface Message<T> {
    Topic getTopic();

    T getPayload();
}

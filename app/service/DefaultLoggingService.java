package service;

import play.Logger;

/**
 * @author Alexander Hanschke
 */
public class DefaultLoggingService implements LoggingService {
    @Override
    public void debug(String message) {
        Logger.debug(message);
    }
}

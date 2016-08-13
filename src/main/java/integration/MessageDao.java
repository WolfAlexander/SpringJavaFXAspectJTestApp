package integration;

import model.Message;
import javax.sql.DataSource;

interface MessageDao {
    /**
     * This is the method to be used to initialize
     * database resources
     * @param dataSource
     */
    void setDataSource(DataSource dataSource);

    /**
     * This method is used to add(post) new messages to db
     * @param message of type model.Message
     */
    void addMessage(Message message) throws IllegalArgumentException;
}

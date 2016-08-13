package integration;

import model.Message;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

public class MessageJDBCTemplate implements MessageDao{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addMessage(Message message) throws IllegalArgumentException, CannotGetJdbcConnectionException{
        if(message == null)
            throw new IllegalArgumentException("Parameter 'message' is null!");

        message.validateMessageInput();
        String query = "INSERT INTO Messages (name, message) VALUE (?, ?)";
        jdbcTemplate.update(query, message.getUsername(), message.getMessage());
    }
}

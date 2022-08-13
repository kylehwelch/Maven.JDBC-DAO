package dao;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class TestConnectionFactory {

    @Test
    public void testConnectionFactory() {
        Connection connection = ConnectionFactory.getConnection();
        Assert.assertNotNull(connection);
    }
}

package start;

import java.sql.SQLException;
import java.util.logging.Logger;
import presentation.View;

/**
 * @author Macean Marius
 * @since Apr 06, 2021
 */
public class Start {
    protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

    public static void main(String[] args) throws SQLException {

        View panel = new View();
        panel.orderManagementPanel();

    }
}

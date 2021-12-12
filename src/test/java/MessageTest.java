import org.junit.*;
import ua.taxi.base.model.message.Message;
import ua.taxi.server.constants.Constants;
import ua.taxi.server.dao.MessageDao;

import java.util.List;

/**
 * Created by andrii on 31.08.16.
 */
@Ignore
public class MessageTest extends Assert {

    private MessageDao messageDao;
    private Message message = new Message("Test message", "Andrii", "123123123");
    private Message message1 = new Message("Test message2", "Andrii", "123123123");



    @BeforeClass
    public static void initTestSQL() {
        TestUtils.scriptRun(Constants.SQL_CREATE_TEST_SCRIPT);
        TestUtils.init();
    }

    @Before
    public void initUserDao() {
        messageDao = TestUtils.getMessageDao();
    }

    @Test
    public void addMessage() {
        int id = messageDao.addMessage(message);
        assertEquals(id, 1);
    }

    @Test
    public void getMessage() {
        int id = messageDao.addMessage(message);
        Message message2 = messageDao.getMessage(id);
        assertEquals(message.getMessage(), message2.getMessage());
    }

    @Test
    public void getAllMessage() {
        messageDao.addMessage(message);
        messageDao.addMessage(message1);
        List<Message> list = messageDao.getAllMessages();
        assertEquals(list.size(), 2);
    }

    @Test
    public void edit() {
        int id = messageDao.addMessage(message);
        messageDao.edit(id, "new message");
        Message message3 = messageDao.getMessage(id);
        assertEquals(message3.getMessage(), "new message");
    }


    @After
    public void clearBase() {
        TestUtils.clearMessages();
    }

    @AfterClass
    public static void removeTestSQL() {
        TestUtils.scriptRun(Constants.SQL_REMOVE_TEST_SCRIPT);
    }


}

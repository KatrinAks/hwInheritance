import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldSearchSimpleTrue() {
      SimpleTask simpleTask = new SimpleTask(10, "выполнить задание");

        simpleTask.matches("выполнить задание");


        boolean expected = true;
        boolean actual = simpleTask.matches("выполнить задание");

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldSearchSimpleFalse() {
        SimpleTask simpleTask = new SimpleTask(10, "выполнить задание");

        simpleTask.matches("не выполнить задание");


        boolean expected = false;
        boolean actual = simpleTask.matches("не выполнить задание");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchEpicTrue() {
        String[] subtasks = {"купить ручку", "купить карандаш"};
        Epic epic = new Epic(88, subtasks);

        epic.matches("купить ручку");

        boolean expected = true;
        boolean actual = epic.matches("купить ручку");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchEpicFalse() {
        String[] subtasks = {"купить ручку", "купить карандаш"};
        Epic epic = new Epic(88, subtasks);

        epic.matches("купить линейку");

        boolean expected = false;
        boolean actual = epic.matches("купить линейку");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeetingProjectTrue() {
        Meeting meeting = new Meeting(32, "выполнить дз", "Нетология", "к понедельнику");

        meeting.matches("Нетология");

        boolean expected = true;
        boolean actual = meeting.matches("Нетология");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeetingProjectFalse() {
        Meeting meeting = new Meeting(32,"выполнить дз", "Нетология", "к понедельнику");

        meeting.matches("НЕтология");

        boolean expected = false;
        boolean actual = meeting.matches("НЕтология");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeetingTopicTrue() {
        Meeting meeting = new Meeting(32, "выполнить дз", "Нетология", "к понедельнику");

        meeting.matches("выполнить дз");

        boolean expected = true;
        boolean actual = meeting.matches("выполнить дз");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeetingTopicFalse() {
        Meeting meeting = new Meeting(32, "выполнить дз", "Нетология", "к понедельнику");

        meeting.matches("не выполнить");

        boolean expected = false;
        boolean actual = meeting.matches("не выполнить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeetingStartFalse() {
        Meeting meeting = new Meeting(32, "выполнить дз", "Нетология", "к понедельнику");

        meeting.matches("к понедельнику");

        boolean expected = false;
        boolean actual = meeting.matches("к понедельнику");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTask() {
        Task task = new Task(10);

        int expected = 10;
        int actual = task.getId();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldTaskEquals() {
        Task task = new Task(5);



    }
}

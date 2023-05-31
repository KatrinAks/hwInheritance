import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldSearchSimple() {
      SimpleTask simpleTask = new SimpleTask(10, "выполнить задание");

        simpleTask.matches("выполнить задание");


        Task expected = simpleTask;
        Task actual = task.matches();

        Assertions.assertEquals(expected, actual);


    }
}

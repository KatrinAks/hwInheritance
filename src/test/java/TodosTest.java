import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

         String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        TodosManager todos = new TodosManager();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTodosSearchTitleTopicTrue() {
        SimpleTask simpleTask = new SimpleTask(10, "выполнить задание");

        String[] subtasks = {"купить ручку", "купить карандаш"};
        Epic epic = new Epic(88, subtasks);

        Meeting meeting = new Meeting(
                32,
                "выполнить дз",
                "Нетология",
                "к понедельнику"
        );

        TodosManager todos = new TodosManager();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.search("выполнить");

        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("выполнить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTodosSearchTitleTopicFalse() {
        SimpleTask simpleTask = new SimpleTask(10, "выполнить задание");

        String[] subtasks = {"купить ручку", "купить карандаш"};
        Epic epic = new Epic(88, subtasks);

        Meeting meeting = new Meeting(
                32,
                "выполнить дз",
                "Нетология",
                "к понедельнику"
        );

        TodosManager todos = new TodosManager();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.search("не выполнить");

        Task[] expected = {};
        Task[] actual = todos.search("не выполнить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTodosSearchSubtasksTrue() {
        SimpleTask simpleTask = new SimpleTask(10, "выполнить задание");

        String[] subtasks = {"купить ручку", "купить карандаш"};
        Epic epic = new Epic(88, subtasks);

        Meeting meeting = new Meeting(
                32,
                "выполнить дз",
                "Нетология",
                "к понедельнику"
        );

        TodosManager todos = new TodosManager();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.search("купить ручку");

        Task[] expected = {epic};
        Task[] actual = todos.search("купить ручку");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTodosSearchSubtasksFalse() {
        SimpleTask simpleTask = new SimpleTask(10, "выполнить задание");

        String[] subtasks = {"купить ручку", "купить карандаш"};
        Epic epic = new Epic(88, subtasks);

        Meeting meeting = new Meeting(
                32,
                "выполнить дз",
                "Нетология",
                "к понедельнику"
        );

        TodosManager todos = new TodosManager();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.search("передать ручку");

        Task[] expected = {};
        Task[] actual = todos.search("передать ручку");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTodosSearchProjectTrue() {
        SimpleTask simpleTask = new SimpleTask(10, "выполнить задание");

        String[] subtasks = {"купить ручку", "купить карандаш"};
        Epic epic = new Epic(88, subtasks);

        Meeting meeting = new Meeting(
                32,
                "выполнить дз",
                "Нетология",
                "к понедельнику"
        );

        TodosManager todos = new TodosManager();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.search("Нетология");

        Task[] expected = {meeting};
        Task[] actual = todos.search("Нетология");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTodosSearchProjectFalse() {
        SimpleTask simpleTask = new SimpleTask(10, "выполнить задание");

        String[] subtasks = {"купить ручку", "купить карандаш"};
        Epic epic = new Epic(88, subtasks);

        Meeting meeting = new Meeting(
                32,
                "выполнить дз",
                "Нетология",
                "к понедельнику"
        );

        TodosManager todos = new TodosManager();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.search("НетологиЯ");

        Task[] expected = {};
        Task[] actual = todos.search("НетологиЯ");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTodosSearchStartFalse() {
        SimpleTask simpleTask = new SimpleTask(10, "выполнить задание");

        String[] subtasks = {"купить ручку", "купить карандаш"};
        Epic epic = new Epic(88, subtasks);

        Meeting meeting = new Meeting(
                32,
                "выполнить дз",
                "Нетология",
                "к понедельнику"
        );

        TodosManager todos = new TodosManager();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.search("к понедельнику");

        Task[] expected = {};
        Task[] actual = todos.search("к понедельнику");
        Assertions.assertArrayEquals(expected, actual);
    }




}

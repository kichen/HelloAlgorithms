import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BubbleSort.class, InsertSort.class, ShellSort.class,
		SelectionSort.class, MergeSort.class })
public class TestMain {

}

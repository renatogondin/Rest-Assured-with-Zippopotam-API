package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import renato.BasicTests;
import renato.Md5Test;
import renato.SpringBootBackEndTest;

@RunWith(Suite.class)
@SuiteClasses({BasicTests.class, Md5Test.class, SpringBootBackEndTest.class})
public class SuiteExecution {

}

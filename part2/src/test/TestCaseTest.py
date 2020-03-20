from src.main.TestCase import TestCase
from src.main.TestResult import TestResult
from src.main.TestSuite import TestSuite
from src.main.WasRun import WasRun


class TestCaseTest(TestCase):

    def setUp(self):
        self.result = TestResult()

    def testTemplateMethod(self):
        test = WasRun('testMethod')
        test.run(self.result)
        assert "setUp testMethod tearDown " == test.log

    def testResult(self):
        test = WasRun("testMethod")
        test.run(self.result)
        assert "1 run, 0 failed" == self.result.summary()

    def testFailedResult(self):
        test = WasRun("testBrokenMethod")
        test.run(self.result)
        assert "1 run, 1 failed" == self.result.summary()

    def testFailedResultFormatting(self):
        self.result.testStarted()
        self.result.testFailed()
        assert "1 run, 1 failed" == self.result.summary()

    def testSuite(self):
        suite = TestSuite()
        suite.add(WasRun("testMethod"))
        suite.add(WasRun("testBrokenMethod"))
        suite.run(self.result)
        assert "2 run, 1 failed" == self.result.summary()

suite = TestSuite()
suite.add(TestCaseTest("testTemplateMethod"))
suite.add(TestCaseTest("testResult"))
suite.add(TestCaseTest("testFailedResult"))
suite.add(TestCaseTest("testFailedResultFormatting"))
suite.add(TestCaseTest("testSuite"))
result = TestResult()
suite.run(result)
print(result.summary())

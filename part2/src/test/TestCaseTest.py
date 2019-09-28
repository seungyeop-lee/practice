from src.main.TestCase import TestCase
from src.main.WasRun import WasRun


class TestCaseTest(TestCase):

    def testTemplateMethod(self):
        test = WasRun('testMethod')
        test.run()
        assert "setUp testMethod tearDown " == test.log

    def testResult(self):
        test = WasRun("testMethod")
        result = test.run()
        assert "1 run, 0 failed" == result.summary()

    def testFailedResult(self):
        test = WasRun("testBrokenMethod")
        result = test.run()
        assert "1 run, 1 failed" == result.summary()

TestCaseTest("testTemplateMethod").run()
TestCaseTest("testResult").run()
# TestCaseTest("testFailedResult").run()

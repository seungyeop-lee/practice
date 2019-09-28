from src.main.TestCase import TestCase
from src.main.WasRun import WasRun


class TestCaseTest(TestCase):
    def testRunning(self):
        test = WasRun("testMethod")
        assert not test.wasRun
        test.run()
        assert test.wasRun


TestCaseTest("testRunning").run()
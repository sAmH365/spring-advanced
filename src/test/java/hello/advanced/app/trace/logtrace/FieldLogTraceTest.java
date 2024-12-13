package hello.advanced.app.trace.logtrace;

import hello.advanced.app.trace.TraceStatus;
import org.junit.jupiter.api.Test;

public class FieldLogTraceTest {

  FieldLogTrace trace = new FieldLogTrace();

  @Test
  void begin_end_level2() {
    TraceStatus status1 = trace.begin("hello1");
    TraceStatus status2 = trace.begin("hello2");
    TraceStatus status3 = trace.begin("hello3");
    TraceStatus status4 = trace.begin("hello4");
    trace.end(status4);
    trace.end(status3);
    trace.end(status2);
    trace.end(status1);
  }

  @Test
  void begin_exception_level2() {
    TraceStatus status1 = trace.begin("hello1");
    TraceStatus status2 = trace.begin("hello2");
    trace.exception(status2, new IllegalArgumentException());
    trace.exception(status1, new IllegalArgumentException());
  }
}

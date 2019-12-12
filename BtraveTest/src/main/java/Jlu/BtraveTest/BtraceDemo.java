package Jlu.BtraveTest;
import com.sun.btrace.annotations.BTrace;

import com.sun.btrace.annotations.OnMethod;

import static com.sun.btrace.BTraceUtils.println;
@BTrace
public class BtraceDemo {
	@OnMethod(clazz = "java.lang.Thread", method = "start")
	public static void onThreadStart() {
	println("tracing method start");

	}
}

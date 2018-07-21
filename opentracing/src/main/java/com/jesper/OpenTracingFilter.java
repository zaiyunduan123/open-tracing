package com.jesper;


import com.weibo.api.motan.filter.Filter;
import com.weibo.api.motan.rpc.Caller;
import com.weibo.api.motan.rpc.Provider;
import com.weibo.api.motan.rpc.Request;
import com.weibo.api.motan.rpc.Response;
import com.weibo.api.motan.util.MotanFrameworkUtil;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.trace.DefaultTracer;

/**
 * Created by jiangyunxiong on 2018/7/21.
 */
public class OpenTracingFilter implements Filter {
    @Override
    public Response filter(Caller<?> caller, Request request) {
        Tracer tracer = getTracer();
        if (tracer == null || tracer instanceof DefaultTracer) {
            return caller.call(request);
        }
        if (caller instanceof Provider) {
            return processProviderTrace(tracer, caller, request);
        }

        return null;
    }

    private Response processProviderTrace(Tracer tracer, Caller<?> caller, Request request) {
        Span span = extractTraceInfo(request, tracer);
        return null;
    }

    private Span extractTraceInfo(Request request, Tracer tracer) {
        return null;
    }

    private String buildOperationName(Request request) {
        return "Motan_" + MotanFrameworkUtil.getGroupMethodString(request);
    }


    protected Tracer getTracer() {
        return OpenTracingContext.getTracer();
    }
}

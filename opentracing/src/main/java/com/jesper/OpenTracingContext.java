package com.jesper;

import com.weibo.api.motan.rpc.RpcContext;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;

/**
 * Created by jiangyunxiong on 2018/7/21.
 */
public class OpenTracingContext {

    public static TraceFactory traceFactory = null;
    public static final String ACTIVE_SPAN = "active_span";

    public static Tracer getTracer(){
        return traceFactory.getTracer();
    }

    public static Span getActiveSpan(){
        Object span = RpcContext.getContext().getAttribute(ACTIVE_SPAN);
        if (span != null && span instanceof Span){
            return (Span) span;
        }
        return null;
    }

    public static void setActiveSpan(Span span){
        RpcContext.getContext().putAttribute(ACTIVE_SPAN, span);
    }

    public void setTraceFactory(MyTracerFactory traceFactory){
        OpenTracingContext.traceFactory = traceFactory;
    }
}

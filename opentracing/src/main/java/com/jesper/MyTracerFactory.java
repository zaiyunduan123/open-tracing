package com.jesper;


import org.springframework.cloud.sleuth.Tracer;

/**
 * Created by jiangyunxiong on 2018/7/21.
 */
public class MyTracerFactory implements TraceFactory {
    @Override
    public Tracer getTracer() {
        return null;
    }
}

package com.jesper;

import org.springframework.cloud.sleuth.Tracer;

/**
 * Created by jiangyunxiong on 2018/7/21.
 */
public interface TraceFactory {

    Tracer getTracer();

}

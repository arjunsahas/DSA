package com.arjun;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** Created by arjuns on 22/12/16. */
public class ProxyTest {
  public static void main(String[] args) throws Throwable {
    SampleInterface invoke = new ProxyTest().invoke();
    System.out.println(invoke.sample());
  }

  public SampleInterface invoke() throws Throwable {
    //        Class<?> proxyClass = Proxy.getProxyClass(this.getClass().getClassLoader(), new
    // Class[]{SampleInterface.class});
    //        InvocationHandler invocationHandler = Proxy.getInvocationHandler(proxyClass);
    //        invocationHandler.invoke(proxyClass, Sample.class.getMethod("sample"), new
    // Object[]{});
    SampleInterface o =
        (SampleInterface)
            Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[] {SampleInterface.class},
                new InvocationHandler() {
                  @Override
                  public Object invoke(final Object proxy, final Method method, final Object[] args)
                      throws Throwable {
                    return new Sample().sample();
                  }
                });
    return o;
  }
}

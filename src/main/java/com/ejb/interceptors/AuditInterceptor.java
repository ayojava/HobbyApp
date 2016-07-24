package com.ejb.interceptors;

import com.jpa.entities.UserHobby;
import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class AuditInterceptor {

    @Resource
    private EJBContext context;

    @AroundInvoke
    public Object methodInterceptor(InvocationContext ctx) throws Exception {
        System.out.println("::: Method Name :::: " + ctx.getMethod().getName());
        if (context != null) {
            Object[] parameters = ctx.getParameters();
            UserHobby userHobby = (UserHobby) parameters[0];
            if (userHobby != null) {
                userHobby.setCreatedBy(context.getCallerPrincipal().getName());
                userHobby.setCreatedOn(new Date());
                ctx.setParameters(new Object[]{userHobby});
            }
        } else {
            System.out.println("::: Inject EJBContext is Null :::: ");
        }
        return ctx.proceed();
    }
}

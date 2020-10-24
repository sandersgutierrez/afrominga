package afrominga.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("Hello from LoginFilter.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("I am running the LoginFilter tasks.");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("Goodbie from LoginFilter");
    }
}

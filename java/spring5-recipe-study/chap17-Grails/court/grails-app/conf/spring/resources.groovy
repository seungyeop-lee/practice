import org.springframework.web.servlet.i18n.SessionLocaleResolver

// Place your Spring DSL code here
beans = {
    //스프링의 로케일 리졸버를 사용하여 특정 언어를 강제 할 수 있다.
    localeResolver(SessionLocaleResolver) {
        defaultLocale = Locale.ENGLISH
        Locale.setDefault(Locale.ENGLISH)
    }
}

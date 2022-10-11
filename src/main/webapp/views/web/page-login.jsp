<%@ include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <main class="row content__page">
            <section class="column large-full entry format-standard">
                <div class="media-wrap">
                    <div>
                        <img src="images/thumbs/contact/contact-1000.jpg" srcset="images/thumbs/contact/contact-2000.jpg 2000w,
                                      images/thumbs/contact/contact-1000.jpg 1000w,
                                      images/thumbs/contact/contact-500.jpg 500w" sizes="(max-width: 2000px) 100vw, 2000px" alt="">
                    </div>
                </div>

                <div class="content__page-header">
                    <h1 class="display-1">
                        Login
                    </h1>
                </div> <!-- end content__page-header -->

                <c:if test="${requestScope.get('alert') != null}">
                    <div class="alert ${requestScope.alert}">
                        <span class="alert-closeBtn">&times;</span>
                         ${requestScope.message}
                    </div>
                </c:if>

                <form name="contactForm" id="contactForm" method="post" action="<c:url value="/login"/>" autocomplete="off">
                    <fieldset>

                        <div class="form-field">
                            <input name="username" class="full-width" placeholder="User Name" value="" type="text">
                        </div>

                        <div class="form-field">
                            <input name="password" class="full-width" placeholder="Password" value="" type="password">
                        </div>

                        <input name="submit" id="submit" class="btn btn--primary btn-wide btn--large full-width" value="Login" type="submit">
                    </fieldset>
                </form> <!-- end form -->
            </section>

            <div class="content__page-header column large-full">
                <div class="footer__copyright">
                    <span><a href="<c:url value="/register"/>">Register</a></span>
                    <span><a href="#">Forget password</a></span>
                </div>
            </div>
        </main>
    </body>
</html>

<%@ include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Register</title>


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
                        Register
                    </h1>
                </div> <!-- end content__page-header -->


                <div class="alert success" hidden>
                    <span class="alert-closeBtn">&times;</span>
                </div>

                <form id="formSubmit">
                    <fieldset>

                        <div class="form-field">
                            <input name="username" class="full-width" placeholder="User Name" value="" type="text">
                        </div>

                        <div class="form-field">
                            <input name="password" class="full-width" placeholder="Password" value="" type="password">
                        </div>

                        <div class="form-field">
                            <input name="fullName" class="full-width" placeholder="Full name" value="" type="text">
                        </div>

                        <div class="form-field">
                            <input name="email" class="full-width" placeholder="Email" value="" type="email">
                        </div>

                        <div class="form-field">
                            <input name="phone" class="full-width" placeholder="Phone" value="" type="number">
                        </div>

                        <input type="button" class="btn btn--primary btn-wide btn--large full-width"
                               value="save"
                               id="btnSubmit" >
                    </fieldset>
                </form> <!-- end form -->
            </section>

            <div class="content__page-header column large-full">
                <div class="footer__copyright">
                    <span><a href="<c:url value="/login"/>">Login</a></span>
                    <span><a href="#">Forget password</a></span>
                </div>
            </div>
        </main>

        <c:url var="APIUser" value="/api-user"/>
        <script>
            function updateUser(data) {
                $.ajax({
                    url: '${APIUser}',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify(data),
                    datatype: 'json',
                    success: function (result) {
                        if (result === 'fail') {
                            alert("Ten tai khoan da ton tai");
                            return;
                        }
                        alert("Dang ky thanh cong");
                    },
                    error: function (error) {
                        alert("Loi he thong!");
                    }
                })
            }

            $('#btnSubmit').click(function (e) {
                e.preventDefault();
                let data = {};
                let formData = $('#formSubmit').serializeArray();
                $.each(formData, function (i, v){
                    data["" + v.name + ""] = v.value;
                })
                updateUser(data);
            })
        </script>
    </body>
</html>

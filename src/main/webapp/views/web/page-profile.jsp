<%@ include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Profile</title>
    </head>
    <body>
        <main class="row content__page">
            <section class="column large-full entry format-standard">

                <form id="formSubmit">
                    <fieldset>
                        <c:set var="user" value="${requestScope.get('UserModel')}"/>

                        <div class="container">
                            <div class="avatar-upload">
                                <div class="avatar-edit">
                                    <input type='file' name="avatar" id="imageUpload" accept=".png, .jpg, .jpeg"/>
                                    <label for="imageUpload" style="line-height: 1"></label>
                                </div>
                                <div class="avatar-preview" style="box-sizing: content-box">
                                    <c:url value="/image/${user.avatar}" var="UserImageURL"/>
                                    <div id="imagePreview" style="background-image: url(${UserImageURL});">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-field">
                            <label class="label-width">Full name</label>
                            <input name="fullName" class="full-width" value="${user.fullName}" type="text">
                        </div>

                        <div class="form-field">
                            <label class="label-width">Email</label>
                            <input name="email" class="full-width" value="${user.email}" type="email">
                        </div>

                        <div class="form-field">
                            <label class="label-width">Phone</label>
                            <input name="phone" class="full-width" value="${user.phone}" type="number">
                        </div>

                        <div class="form-field">
                            <label class="label-width">Password</label>
                            <input name="password" class="full-width" value="${user.password}" type="password">
                        </div>

                        <input type="hidden" value="${user.id}" id ="id" name="id" >
                        <input type="button" class="btn btn--primary btn-wide btn--large full-width"
                               value="save"
                               id="btnSubmit" >
                    </fieldset>
                </form> <!-- end form -->
            </section>
        </main>
        
        <c:url var="APIUser" value="/api-user"/>

        <script>
            function updateUser(data) {
                $.ajax({
                    url: '${APIUser}',
                    type: 'PUT',
                    contentType: 'application/json',
                    data: JSON.stringify(data),
                    datatype: 'json',
                    success: function (result) {
                        if (result === 'fail') {
                            alert("Update that bai");
                            return;
                        }
                        alert("Update thanh cong");
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

                let avatar = $("#imagePreview").css("background-image");
                if (avatar.includes("/WebBlog_war_exploded/image/")) {
                    data['avatar'] = null;
                    updateUser(data);
                    return;
                }

                avatar = avatar.replace('url(','').replace(')','').replace(/\"/gi, "");
                data['avatar'] = avatar.replace(/^data:image\/(png|jpg|jpeg);base64,/, "");//base64ToBlob(base64ImageContent, 'image/png');
                updateUser(data);
            })
        </script>
    </body>
</html>

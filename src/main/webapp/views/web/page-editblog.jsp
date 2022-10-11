<%@ include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Profile</title>
    </head>
    <body>
        <main class="row s-styles content__page">
            <section id="styles" class="column large-full entry format-standard">
                <div class="row add-bottom">
                    <div class="column large-full">
                        <div class="row row-baseline">
                            <a href="<c:url value="/manage"/>"><h3>Blog Manager</h3></a>
                            <h3>&nbsp;>&nbsp;</h3>
                            <a href=""><h3>Edit</h3></a>

                            <div class="column" style="display: flex; justify-content: flex-end">
                                <c:url var="folderManage" value="/manage/file"/>
                                <a href="#" onClick="MyWindow=window.open('${folderManage}','MyWindow','width=1000,height=700'); return false;"
                                   class="pgn__num" style="padding: 6px; font-size: x-large">
                                    <i class="fa fa-folder-open-o bigger-110"></i>
                                </a>
                            </div>
                        </div>

                        <form>
                            <div>
                                <label for="thumbnail">Thumbnail</label>
                                <input name="thumbnail" id="thumbnail" class="full-width" type="file">
                            </div>

                            <div>
                                <label for="title">Title</label>
                                <input name="title" id="title" class="full-width">
                            </div>

                            <div>
                                <label for="shortDescription">Short description</label>
                                <input name="shortDescription" id="shortDescription" class="full-width">
                            </div>

                            <div>
                                <label for="sampleRecipientInput">Category</label>
                                <div class="ss-custom-select">
                                    <select class="full-width" id="sampleRecipientInput">
                                        <option value="Option 1">Questions</option>
                                        <option value="Option 2">Report</option>
                                        <option value="Option 3">Others</option>
                                    </select>
                                </div>
                            </div>

                            <label class="add-bottom">
                                <input type="checkbox">
                                <span class="label-text">Send a copy to yourself</span>
                            </label>

                            <label for="content">Message</label>
                            <textarea name="content" id="content" class="full-width"></textarea>

                            <input class="btn--primary full-width" type="submit" value="Submit">
                        </form>
                    </div>
                </div> <!-- end row -->
            </section>
        </main>

        <script>
            let editor = '';
            $(document).ready(function(){
                editor = CKEDITOR.replace('content');

            });
        </script>
    </body>
</html>

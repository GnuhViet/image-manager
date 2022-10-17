<%@ include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <title>check file manager - Bootdey.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/4.5.6/css/ionicons.min.css" integrity="sha512-0/rEDduZGrqo4riUlwqyuHDQzp2D1ZCgH/gFIfjMIL5az8so6ZiXyhf1Rg8i6xsjv+z/Ubc4tt1thLigEcu6Ug==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script type='text/javascript' src='<c:url value="/assets/admin/js/jquery-2.2.3.min.js" />'></script>
    </head  >
    <body>
        <div class="container flex-grow-1 light-style container-p-y">
            <c:set var="FolderModel" value="${requestScope.get('FolderModel')}"/>

            <div class="container-m-nx container-m-ny bg-lightest mb-3">
                <ol class="breadcrumb text-big container-p-x py-3 m-0">
                    <c:set var="path" value=""/>
                    <c:forEach var="FolderName" items="${FolderModel.folderPath.split('/')}">
                        <c:set var="path" value="${empty path ? path.concat(FolderName) : path.concat('/').concat(FolderName)}"/>
                        <c:url var="folderURL" value="/manage/file">
                            <c:param name="folderPath" value="${path}"/>
                        </c:url>
                        <li class="breadcrumb-item">
                            <a href="${folderURL}">${FolderName}</a>
                        </li>
                    </c:forEach>
                </ol>

                <hr class="m-0"/>

                <div class="file-manager-actions container-p-x py-2">
                    <div>
                        <button type="button" class="btn btn-primary mr-2">
                            <i class="ion ion-md-cloud-upload"></i>&nbsp; Upload
                        </button>
                        <button type="button" class="btn btn-secondary icon-btn mr-2" disabled="">
                            <i class="ion ion-md-cloud-download"></i>
                        </button>
                        <div class="btn-group mr-2">
                            <button type="button" class="btn btn-default md-btn-flat dropdown-toggle px-2" data-toggle="dropdown">
                                <i class="ion ion-ios-settings"></i></button>
                            <div class="dropdown-menu">
                                <button value="${FolderModel.folderPath}" class="btnListUpdate move dropdown-item">Move</button>
                                <button value="${FolderModel.folderPath}" class="btnListUpdate copy dropdown-item">Copy</button>
                                <button value="${FolderModel.folderPath}" class="btnListUpdate remove dropdown-item">Remove</button>
                            </div>
                        </div>
                    </div>
                    <div>
                        <button type="button" style="text-align: right" class="btn btn-secondary icon-btn mr-2" disabled="">
                            <i class="ion ion-md-cloud-download"></i> Paste
                        </button>
                    </div>
                </div>

                <hr class="m-0"/>
            </div>

            <div class="file-manager-container file-manager-col-view">
                <div class="file-manager-row-header">
                    <div class="file-item-name pb-2">Filename</div>
                    <div class="file-item-changed pb-2">Changed</div>
                </div>


                <c:forEach var="ChildFolderName" items="${FolderModel.childFolders}">
                    <div class="file-item" style="z-index: 1">
                        <c:url var="folderURL" value="/manage/file?folderPath=${FolderModel.folderPath}/${ChildFolderName}"/>
                        <a href="${folderURL}" class="file-item-name">
                            <div class="file-item-select-bg bg-primary"></div>
                        </a>
                        <label class="file-item-checkbox custom-control custom-checkbox">
                            <input value="${ChildFolderName}" type="checkbox" class="custom-control-input"/>
                            <span class="custom-control-label"></span>
                        </label>
                        <a href="${folderURL}" class="file-item-name" style="text-decoration: none">
                            <div class="file-item-icon far fa-folder text-secondary"></div>
                        </a>
                        <a href="${folderURL}" class="file-item-name" style="text-decoration: none">
                                ${ChildFolderName}
                        </a>
                        <div class="file-item-changed">02/13/2018</div>
                        <div class="file-item-actions btn-group">
                            <button type="button" class="btn btn-default btn-sm rounded-pill icon-btn borderless md-btn-flat hide-arrow" data-toggle="dropdown">
                                <i class="ion ion-ios-settings"></i>
                            </button>
                            <div class="dropdown-menu dropdown-menu-right">
                                <form class="formRename-${ChildFolderName}" style="margin-bottom: 0">
                                    <div class="dropdown-item">
                                        <input name="folderNewName" value="${ChildFolderName}"  type="text" style="width: 112px">
                                        <input name="folderName" value="${ChildFolderName}" type="hidden">
                                        <input name="folderPath" value="${FolderModel.folderPath}" type="hidden" >
                                        <button type="submit" value="${ChildFolderName}" class="btn btnSubmitRename btn-secondary mr-2">
                                            <i class="ion ion-md-checkmark"></i>
                                        </button>
                                    </div>
                                </form>
                                <button value="${FolderModel.folderPath}/${ChildFolderName}" class="btnRemove dropdown-item">Remove</button>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <div class="file-item">
                    <button type="button" class="btn btn-default btn-sm rounded-pill icon-btn borderless md-btn-flat hide-arrow" data-toggle="dropdown">
                        <i class="file-item-icon file-item-level-up fa fa-plus text-secondary"></i>
                        New Folder
                    </button>
                    <div class="dropdown-menu dropdown-menu-right">
                        <form id="formCreate">
                            <label class="dropdown-item">Name:
                                <input id="createFolderName" value="" name="folderName" type="text">
                            </label>
                            <input id="createFolderPath" type="hidden" name="folderPath" value="${FolderModel.folderPath}">
                            <div class="dropdown-item">
                                <button id="btnSubmitCreate" type="submit" class="btn btn-primary mr-2">
                                    <i class="ion ion-md-cloud-done"></i>&nbsp; submit
                                </button>
                            </div>
                        </form>
                    </div>
                </div>

                <%--            <div class="file-item">--%>
                <%--                <div class="file-item-select-bg bg-primary"></div>--%>
                <%--                <label class="file-item-checkbox custom-control custom-checkbox">--%>
                <%--                    <input type="checkbox" class="custom-control-input"/>--%>
                <%--                    <span class="custom-control-label"></span>--%>
                <%--                </label>--%>
                <%--                <div class="file-item-img" style="background-image: url(https://bootdey.com/img/Content/avatar/avatar1.png);"></div>--%>
                <%--                <a href="javascript:void(0)" class="file-item-name">--%>
                <%--                    Image-1.jpg--%>
                <%--                </a>--%>
                <%--                <div class="file-item-changed">02/20/2018</div>--%>
                <%--                <div class="file-item-actions btn-group">--%>
                <%--                    <button type="button" class="btn btn-default btn-sm rounded-pill icon-btn borderless md-btn-flat hide-arrow dropdown-toggle" data-toggle="dropdown">--%>
                <%--                        <i class="ion ion-ios-more"></i></button>--%>
                <%--                    <div class="dropdown-menu dropdown-menu-right">--%>
                <%--                        <a class="dropdown-item" href="javascript:void(0)">Rename</a>--%>
                <%--                        <a class="dropdown-item" href="javascript:void(0)">Move</a>--%>
                <%--                        <a class="dropdown-item" href="javascript:void(0)">Copy</a>--%>
                <%--                        <a class="dropdown-item" href="javascript:void(0)">Remove</a>--%>
                <%--                    </div>--%>
                <%--                </div>--%>
                <%--            </div>--%>

            </div>
        </div>

        <style type="text/css">
            body {
                margin-top: 20px;
            }

            .file-manager-actions {
                display: -ms-flexbox;
                display: flex;
                -ms-flex-wrap: wrap;
                flex-wrap: wrap;
                -ms-flex-pack: justify;
                justify-content: space-between;
            }

            .file-manager-actions > * {
                display: -ms-flexbox;
                display: flex;
                -ms-flex-wrap: wrap;
                flex-wrap: wrap;
            }

            .file-manager-container {
                display: -ms-flexbox;
                display: flex;
                -ms-flex-wrap: wrap;
                flex-wrap: wrap;
            }

            .file-item {
                position: relative;
                z-index: 1;
                -ms-flex: 0 0 auto;
                flex: 0 0 auto;
                border: 1px solid #eee;
                cursor: pointer;
            }

            .file-item:hover,
            .file-item.focused {
                border-color: rgba(0, 0, 0, 0.05);
            }

            .file-item.focused {
                z-index: 2;
            }

            .file-item * {
                -ms-flex-negative: 0;
                flex-shrink: 0;
                text-decoration: none;
            }

            .dark-style .file-item:hover,
            .dark-style .file-item.focused {
                border-color: rgba(255, 255, 255, 0.2);
            }

            .file-item-checkbox {
                margin: 0 !important;
            }

            .file-item-select-bg {
                position: absolute;
                top: 0;
                right: 0;
                bottom: 0;
                left: 0;
                z-index: -1;
                opacity: 0;
            }

            .file-item-img {
                background-color: transparent;
                background-position: center center;
                background-size: cover;
            }

            .file-item-name {
                display: block;
                overflow: hidden;
            }

            .file-manager-col-view .file-item {
                margin: 0 0.25rem 0.25rem 0;
                padding: 1.25rem 0 1rem 0;
                width: 9rem;
                text-align: center;
            }

            [dir="rtl"] .file-manager-col-view .file-item {
                margin-right: 0;
                margin-left: 0.25rem;
            }

            .file-manager-col-view .file-item-img,
            .file-manager-col-view .file-item-icon {
                display: block;
                margin: 0 auto 0.75rem auto;
                width: 4rem;
                height: 4rem;
                font-size: 2.5rem;
                line-height: 4rem;
            }

            .file-manager-col-view .file-item-level-up {
                font-size: 1.5rem;
            }

            .file-manager-col-view .file-item-checkbox,
            .file-manager-col-view .file-item-actions {
                position: absolute;
                top: 6px;
            }

            .file-manager-col-view .file-item-checkbox {
                left: 6px;
            }

            [dir="rtl"] .file-manager-col-view .file-item-checkbox {
                right: 6px;
                left: auto;
            }

            .file-manager-col-view .file-item-actions {
                right: 6px;
            }

            [dir="rtl"] .file-manager-col-view .file-item-actions {
                right: auto;
                left: 6px;
            }

            .file-manager-col-view .file-item-name {
                width: 100%;
            }

            .file-manager-col-view .file-manager-row-header,
            .file-manager-col-view .file-item-changed {
                display: none;
            }

            .file-manager-row-view .file-manager-row-header,
            .file-manager-row-view .file-item {
                display: -ms-flexbox;
                display: flex;
                -ms-flex-align: center;
                align-items: center;
                margin: 0 0 0.125rem 0;
                padding: 0.25rem 3rem 0.25rem 2.25em;
                width: 100%;
            }

            [dir="rtl"] .file-manager-row-view .file-manager-row-header,
            [dir="rtl"] .file-manager-row-view .file-item {
                padding-right: 2.25em;
                padding-left: 3rem;
            }

            .file-manager-row-view .file-item-img,
            .file-manager-row-view .file-item-icon {
                display: block;
                margin: 0 1rem;
                width: 2rem;
                height: 2rem;
                text-align: center;
                font-size: 1.25rem;
                line-height: 2rem;
            }

            .file-manager-row-view .file-item-level-up {
                font-size: 1rem;
            }

            .file-manager-row-view .file-item-checkbox,
            .file-manager-row-view .file-item-actions {
                position: absolute;
                top: 50%;
                -webkit-transform: translateY(-50%);
                transform: translateY(-50%);
            }

            .file-manager-row-view .file-item-checkbox {
                left: 10px;
            }

            [dir="rtl"] .file-manager-row-view .file-item-checkbox {
                right: 10px;
                left: auto;
            }

            .file-manager-row-view .file-item-actions {
                right: 10px;
            }

            [dir="rtl"] .file-manager-row-view .file-item-actions {
                right: auto;
                left: 10px;
            }

            .file-manager-row-view .file-item-changed {
                display: none;
                margin-left: auto;
                width: 10rem;
            }

            [dir="rtl"] .file-manager-row-view .file-item-changed {
                margin-right: auto;
                margin-left: 0;
            }

            .file-manager-row-view .file-item-name {
                width: calc(100% - 4rem);
            }

            .file-manager-row-view .file-manager-row-header {
                border-bottom: 2px solid rgba(0, 0, 0, 0.05);
                font-weight: bold;
            }

            .file-manager-row-view .file-manager-row-header .file-item-name {
                margin-left: 4rem;
            }

            [dir="rtl"] .file-manager-row-view .file-manager-row-header .file-item-name {
                margin-right: 4rem;
                margin-left: 0;
            }

            .light-style .file-item-name {
                color: #4e5155 !important;
            }

            .light-style .file-item.selected .file-item-select-bg {
                opacity: 0.15;
            }

            @media (min-width: 768px) {
                .light-style .file-manager-row-view .file-item-changed {
                    display: block;
                }

                .light-style .file-manager-row-view .file-item-name {
                    width: calc(100% - 15rem);
                }
            }


            .material-style .file-item-name {
                color: #4e5155 !important;
            }

            .material-style .file-item.selected .file-item-select-bg {
                opacity: 0.15;
            }

            @media (min-width: 768px) {
                .material-style .file-manager-row-view .file-item-changed {
                    display: block;
                }

                .material-style .file-manager-row-view .file-item-name {
                    width: calc(100% - 15rem);
                }
            }

            .dark-style .file-item-name {
                color: #fff !important;
            }

            .dark-style .file-item.selected .file-item-select-bg {
                opacity: 0.15;
            }

            @media (min-width: 768px) {
                .dark-style .file-manager-row-view .file-item-changed {
                    display: block;
                }

                .dark-style .file-manager-row-view .file-item-name {
                    width: calc(100% - 15rem);
                }
            }
        </style>

        <c:url var="APIUrl" value="/api-folder"/>
        <script>
            function createFolder(data) {
                $.ajax({
                    url: '${APIUrl}',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify(data),
                    success: function (result) {
                        location.reload();
                    },
                    error: function (result) {
                        alert("loi he thong");
                    }
                });
            }

            function deleteFolder(data) {
                $.ajax({
                    url: '${APIUrl}',
                    type: 'DELETE',
                    contentType: 'application/json',
                    data: JSON.stringify(data),
                    success: function (result) {
                        location.reload();
                    },
                    error: function (result) {
                        alert("loi he thong");
                    }
                });
            }

            function updateFolder(data) {
                $.ajax({
                    url: '${APIUrl}',
                    type: 'PUT',
                    contentType: 'application/json',
                    data: JSON.stringify(data),
                    success: function (result) {
                        alert(result);
                        location.reload();
                    },
                    error: function (result) {
                        alert("loi he thong");
                    }
                });
            }

            $('#btnSubmitCreate').click(function (e) {
                e.preventDefault();
                let data = {};
                data['folderPath'] = $('#createFolderPath').val() + '/' + $('#createFolderName').val();
                createFolder(data);
            })

            $('.btnRemove').click(function (e) {
                e.preventDefault();
                let data = {};
                data['folderPath'] = $(this).val();
                alert($(this).val());
                deleteFolder(data);
            })

            $('.btnSubmitRename').click(function (e) {
                e.preventDefault();
                let renameFolder = $(this).val();
                alert($(this).val())
                let data = {};
                let formData = $('.formRename-' + renameFolder).serializeArray();
                $.each(formData, function (i, v) {
                    data[""+v.name+""] = v.value;
                })
                data['updateType'] = 'rename';
                updateFolder(data);
            })

            $('.btnListUpdate').click(function (e) {
                e.preventDefault();
                let data = {};

                let checkItem = $('.file-item-checkbox input[type=checkbox]:checked').map(function () {return $(this).val();}).get();

                let classList = $(this).attr('class').split(/\s+/);

                data[classList[1]+'Folders'] = checkItem;
                data['folderPath'] = $(this).val();
                data['updateType'] = classList[1];
                console.log(data);
            })
        </script>
    </body>
</html>

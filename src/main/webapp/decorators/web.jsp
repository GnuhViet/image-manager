<%@ include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html class="no-js" lang="en">
    <head>
        <!--- basic page needs
        ================================================== -->
        <meta charset="utf-8">
        <title><dec:title default="Typerite - home"/></title>
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- mobile specific metas
        ================================================== -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- CSS
        ================================================== -->
        <link rel="stylesheet" href="<c:url value="/assets/web/css/base.css"/> ">
        <link rel="stylesheet" href="<c:url value="/assets/web/css/vendor.css"/> ">
        <link rel="stylesheet" href="<c:url value="/assets/web/css/main.css"/> ">

        <link rel="stylesheet" href="<c:url value="/assets/web/css/custom.css"/> ">
        <!-- script
        ================================================== -->
        <script src="<c:url value="/assets/web/js/modernizr.js"/> "></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script type='text/javascript' src='<c:url value="/assets/admin/js/jquery-2.2.3.min.js" />'></script>


        <!-- favicons
        ================================================== -->
        <link rel="apple-touch-icon" sizes="180x180" href="<c:url value="/assets/web/apple-touch-icon.png"/>">
        <link rel="icon" type="image/png" sizes="32x32" href="<c:url value="/assets/web/favicon-32x32.png"/>">
        <link rel="icon" type="image/png" sizes="16x16" href="<c:url value="/assets/web/favicon-16x16.png"/>">
        <link rel="manifest" href="<c:url value="/assets/web/site.webmanifest"/>">

        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300" rel="stylesheet">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

        <script src="<c:url value='/ckeditor/ckeditor.js' />"></script>
    </head>

    <body>

        <!-- preloader
        ================================================== -->


        <div id="top" class="s-wrap site-wrapper">
            <%@ include file="/common/web/header.jsp" %>
            <div class="s-content">
                <dec:body/>
            </div> <!-- end s-content -->
            <%@ include file="/common/web/footer.jsp" %>
        </div> <!-- end s-wrap -->

        <!-- Java Script
        ================================================== -->
        <script src="<c:url value="/assets/web/js/jquery-3.2.1.min.js"/>"></script>
        <script src="<c:url value="/assets/web/js/plugins.js"/>"></script>
        <script src="<c:url value="/assets/web/js/main.js"/>"></script>

        <script src="<c:url value="/assets/web/js/custom.js"/>"></script>
    </body>
</html>

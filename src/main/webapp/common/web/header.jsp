<%@ include file="/common/taglib.jsp" %>

<!-- site header
================================================== -->
<header class="s-header">

    <div class="header__top">
        <div class="header__logo">
            <a class="site-logo" href="<c:url value="/home"/>">
                <img src="<c:url value="/assets/web/images/logo.svg"/>" alt="Homepage">
            </a>
        </div>

        <div class="header__search">

            <form role="search" method="get" class="header__search-form" action="#">
                <label>
                    <span class="hide-content">Search for:</span>
                    <input type="search" class="header__search-field" placeholder="Type Keywords" value="" name="s" title="Search for:" autocomplete="off">
                </label>
                <input type="submit" class="header__search-submit" value="Search">
            </form>

            <a href="#0" title="Close Search" class="header__search-close">Close</a>

        </div>  <!-- end header__search -->

        <!-- toggles -->
        <a href="#0" class="header__search-trigger"></a>
        <a href="#0" class="header__menu-toggle"><span>Menu</span></a>

    </div> <!-- end header__top -->

    <nav class="header__nav-wrap">

        <ul class="header__nav">
            <li class="current"><a href="<c:url value="/home"/>" title="">Home</a></li>
            <li class="has-children">
                <a href="#0" title="">Categories</a>
                <ul class="sub-menu">
                    <li><a href="<c:url value="/category"/>">Lifestyle</a></li>
                    <li><a href="<c:url value="/category"/>">Health</a></li>
                    <li><a href="<c:url value="/category"/>">Family</a></li>
                    <li><a href="<c:url value="/category"/>">Management</a></li>
                    <li><a href="<c:url value="/category"/>">Travel</a></li>
                    <li><a href="<c:url value="/category"/>">Work</a></li>
                </ul>
            </li>
            <li class="has-children">
                <a href="#0" title="">Blog Posts</a>
                <ul class="sub-menu">
                    <li><a href="<c:url value="/video"/>">Video Post</a>
                    </li>
                    <li><a href="<c:url value="/video"/>">Audio Post</a>
                    </li>
                    <li>
                        <a href="<c:url value="/video"/>">Gallery Post</a>
                    </li>
                    <li>
                        <a href="<c:url value="/video"/>">Standard Post</a>
                    </li>
                </ul>
            </li>
            <li><a href="<c:url value="/styles"/>" title="">Styles</a></li>
            <li><a href="<c:url value="/about"/>" title="">About</a></li>
            <li><a href="<c:url value="/contact"/>" title="">Contact</a></li>

            <c:choose>
                <c:when test="${sessionScope.get('UserModel') != null}">
                    <li class="has-children">
                        <a href="#0" title="">

                            <img src="<c:url value="/image?type=avatar&filename=${sessionScope.get('UserModel').avatar}"/>"
                            style="vertical-align: middle;width: 40px;height: 40px;border-radius: 50%;">
                            &ensp;${sessionScope.get('UserModel').fullName}
                        </a>
                        <ul class="sub-menu">
                            <li><a href="<c:url value="/profile"/>">Profile</a></li>
                            <li><a href="<c:url value="/manage"/>">Manager blog</a></li>
                            <li><a href="<c:url value="/"/>">Activity</a></li>
                            <li><a href="<c:url value="/logout"/>">Logout</a></li>
                        </ul>
                    </li>
                </c:when>
                <c:otherwise>
                    <li><a href="<c:url value="/login"/>" title="">Login</a></li>
                </c:otherwise>
            </c:choose>
        </ul> <!-- end header__nav -->

        <ul class="header__social">
            <li class="ss-facebook">
                <a href="https://facebook.com/">
                    <span class="screen-reader-text">Facebook</span>
                </a>
            </li>
            <li class="ss-twitter">
                <a href="#0">
                    <span class="screen-reader-text">Twitter</span>
                </a>
            </li>
            <li class="ss-dribbble">
                <a href="#0">
                    <span class="screen-reader-text">Dribbble</span>
                </a>
            </li>
            <li class="ss-pinterest">
                <a href="#0">
                    <span class="screen-reader-text">Behance</span>
                </a>
            </li>
        </ul>

    </nav> <!-- end header__nav-wrap -->


</header>
<!-- end s-header -->

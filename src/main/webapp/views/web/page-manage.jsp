<%@ include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Styles</title>
    </head>
    <body>
        <main class="row s-styles">


            <section id="styles" class="column large-full">
                <div class="row add-bottom">
                    <div class="column large-full">
                        <div class="row row-baseline">
                            <h3>Blog Manager</h3>
                            <div class="column" style="display: flex; justify-content: flex-end">
                                <a class="pgn__num" style="padding: 6px; font-size: x-large" href="#0">
                                    <i class="fa fa-plus-circle bigger-110 purple"></i>
                                </a>
                                <a class="pgn__num" style="padding: 6px; font-size: x-large" href="#0">
                                    <i class="fa fa-trash-o bigger-110 pink"></i>
                                </a>
                                <c:url var="folderManage" value="/manage/file"/>
                                <a href="#" onClick="MyWindow=window.open('${folderManage}','MyWindow','width=1000,height=800'); return false;">
                                    ImageManager
                                </a>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table>
                                <thead>
                                    <tr>
                                        <th><label>
                                            <input type="checkbox" value="">
                                        </label></th>
                                        <th>Title</th>
                                        <th>Categories</th>
                                        <th>CreateDate</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th><label>
                                            <input type="checkbox" value="">
                                        </label></th>
                                        <td>Naruto Uzumaki</td>
                                        <td>16</td>
                                        <td>Male</td>
                                        <td><a class="pgn__num" style="padding: 6px; font-size: x-large" href="#0">
                                            <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                        </a>
                                            <a class="pgn__num" style="padding: 6px; font-size: x-large" href="#0">
                                                <i class="fa fa-trash-o bigger-110 pink"></i>
                                            </a></td>
                                    </tr>
                                    <tr>
                                        <th><label>
                                            <input type="checkbox" value="">
                                        </label></th>
                                        <td>Sakura Haruno</td>
                                        <td>16</td>
                                        <td>Female</td>
                                        <td><a class="pgn__num" style="padding: 6px; font-size: x-large" href="#0">
                                            <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                        </a>
                                            <a class="pgn__num" style="padding: 6px; font-size: x-large" href="#0">
                                                <i class="fa fa-trash-o bigger-110 pink"></i>
                                            </a></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div> <!-- end row -->

                <div class="row">
                    <div class="column large-full">
                        <nav class="pgn">
                            <ul>
                                <li><a class="pgn__prev" href="#0">Prev</a></li>
                                <li><a class="pgn__num" href="#0">1</a></li>
                                <li><span class="pgn__num current">2</span></li>
                                <li><a class="pgn__num" href="#0">3</a></li>
                                <li><a class="pgn__num" href="#0">4</a></li>
                                <li><a class="pgn__num" href="#0">5</a></li>
                                <li><span class="pgn__num dots">…</span></li>
                                <li><a class="pgn__num" href="#0">8</a></li>
                                <li><a class="pgn__next" href="#0">Next</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </section>

        </main>
    </body>
</html>

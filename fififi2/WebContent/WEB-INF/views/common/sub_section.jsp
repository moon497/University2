<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/> 
<section class="category-content col-sm-9">
    <h2 class="category-title">CATEGORY NAME</h2>
    <ul class="media-list">
        <li class="media">
            <div class="media-left">
                <a href="#" title="Post">
                    <img class="media-object" src="img/h1.jpeg" alt="Post">
                </a>
            </div>
            <div class="media-body">
                <h3 class="media-heading"><a href="#" title="Post Title">Post Title</a></h3>
                <p>Aenean vitae dolor sed purus tempus ullamcorper. Integer urna orci, lacinia ut ornare sit amet, luctus quis est. Ut interdum lorem in mattis lobortis. Maecenas tincidunt justo a lobortis facilisis.</p>
                <aside class="meta category-meta">
                    <div class="pull-left">
                        <div class="arc-comment"><a href="#" title="Comment"><i class="fa fa-comments"></i> 0 Comment</a></div>
                        <div class="arc-date">10/15/2016</div>
                    </div>
                    <div class="pull-right">
                        <ul class="arc-share">
                            <li><a href="#" title="Post"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-linkedin"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </aside>                                
            </div>
        </li>
        <li class="media">
            <div class="media-left">
                <a href="#" title="Post">
                    <img class="media-object" src="img/h2.jpg" alt="Post">
                </a>
            </div>
            <div class="media-body">
                <h3 class="media-heading"><a href="#" title="Post Title">Post Title</a></h3>
                <p>Aenean vitae dolor sed purus tempus ullamcorper. Integer urna orci, lacinia ut ornare sit amet, luctus quis est. Ut interdum lorem in mattis lobortis. Maecenas tincidunt justo a lobortis facilisis.</p>
                <aside class="meta category-meta">
                    <div class="pull-left">
                        <div class="arc-comment"><a href="#" title="Comment"><i class="fa fa-comments"></i> 1 Comment</a></div>
                        <div class="arc-date">10/15/2016</div>
                    </div>
                    <div class="pull-right">
                        <ul class="arc-share">
                            <li><a href="#" title="Post"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-linkedin"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </aside>                                
            </div>
        </li>
        <li class="media">
            <div class="media-left">
                <a href="#" title="Post">
                    <img class="media-object" src="img/h3.jpeg" alt="Post">
                </a>
            </div>
            <div class="media-body">
                <h3 class="media-heading"><a href="#" title="Post Title">Post Title</a></h3>
                <p>Aenean vitae dolor sed purus tempus ullamcorper. Integer urna orci, lacinia ut ornare sit amet, luctus quis est. Ut interdum lorem in mattis lobortis. Maecenas tincidunt justo a lobortis facilisis.</p>
                <aside class="meta category-meta">
                    <div class="pull-left">
                        <div class="arc-comment"><a href="#" title="Comment"><i class="fa fa-comments"></i> 2 Comments</a></div>
                        <div class="arc-date">10/15/2016</div>
                    </div>
                    <div class="pull-right">
                        <ul class="arc-share">
                            <li><a href="#" title="Post"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-linkedin"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </aside>                                
            </div>
        </li>
        <li class="media">
            <div class="media-left">
                <a href="#" title="Post">
                    <img class="media-object" src="img/h4.jpeg" alt="Post">
                </a>
            </div>
            <div class="media-body">
                <h3 class="media-heading"><a href="#" title="Post Title">Post Title</a></h3>
                <p>Aenean vitae dolor sed purus tempus ullamcorper. Integer urna orci, lacinia ut ornare sit amet, luctus quis est. Ut interdum lorem in mattis lobortis. Maecenas tincidunt justo a lobortis facilisis.</p>
                <aside class="meta category-meta">
                    <div class="pull-left">
                        <div class="arc-comment"><a href="#" title="Comment"><i class="fa fa-comments"></i> 2 Comments</a></div>
                        <div class="arc-date">10/15/2016</div>
                    </div>
                    <div class="pull-right">
                        <ul class="arc-share">
                            <li><a href="#" title="Post"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-linkedin"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </aside>                                
            </div>
        </li>
        <li class="media">
            <div class="media-left">
                <a href="#" title="Post">
                    <img class="media-object" src="img/h1.jpeg" alt="Post">
                </a>
            </div>
            <div class="media-body">
                <h3 class="media-heading"><a href="#" title="Post Title">Post Title</a></h3>
                <p>Aenean vitae dolor sed purus tempus ullamcorper. Integer urna orci, lacinia ut ornare sit amet, luctus quis est. Ut interdum lorem in mattis lobortis. Maecenas tincidunt justo a lobortis facilisis.</p>
                <aside class="meta category-meta">
                    <div class="pull-left">
                        <div class="arc-comment"><a href="#" title="Comment"><i class="fa fa-comments"></i> 12 Comments</a></div>
                        <div class="arc-date">10/15/2016</div>
                    </div>
                    <div class="pull-right">
                        <ul class="arc-share">
                            <li><a href="#" title="Post"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-linkedin"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </aside>                                
            </div>
        </li>
        <li class="media">
            <div class="media-left">
                <a href="#" title="Post">
                    <img class="media-object" src="img/h2.jpg" alt="Post">
                </a>
            </div>
            <div class="media-body">
                <h3 class="media-heading"><a href="#" title="Post Title">Post Title</a></h3>
                <p>Aenean vitae dolor sed purus tempus ullamcorper. Integer urna orci, lacinia ut ornare sit amet, luctus quis est. Ut interdum lorem in mattis lobortis. Maecenas tincidunt justo a lobortis facilisis.</p>
                <aside class="meta category-meta">
                    <div class="pull-left">
                        <div class="arc-comment"><a href="#" title="Comment"><i class="fa fa-comments"></i> 2 Comments</a></div>
                        <div class="arc-date">10/15/2016</div>
                    </div>
                    <div class="pull-right">
                        <ul class="arc-share">
                            <li><a href="#" title="Post"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-linkedin"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </aside>                                
            </div>
        </li>
        <li class="media">
            <div class="media-left">
                <a href="#" title="Post">
                    <img class="media-object" src="img/h3.jpeg" alt="Post">
                </a>
            </div>
            <div class="media-body">
                <h3 class="media-heading"><a href="#" title="Post Title">Post Title</a></h3>
                <p>Aenean vitae dolor sed purus tempus ullamcorper. Integer urna orci, lacinia ut ornare sit amet, luctus quis est. Ut interdum lorem in mattis lobortis. Maecenas tincidunt justo a lobortis facilisis.</p>
                <aside class="meta category-meta">
                    <div class="pull-left">
                        <div class="arc-comment"><a href="#" title="Comment"><i class="fa fa-comments"></i> 3 Comments</a></div>
                        <div class="arc-date">10/15/2016</div>
                    </div>
                    <div class="pull-right">
                        <ul class="arc-share">
                            <li><a href="#" title="Post"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-linkedin"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </aside>                                
            </div>
        </li>
        <li class="media">
            <div class="media-left">
                <a href="#" title="Post">
                    <img class="media-object" src="img/h4.jpeg" alt="Post">
                </a>
            </div>
            <div class="media-body">
                <h3 class="media-heading"><a href="#" title="Post Title">Post Title</a></h3>
                <p>Aenean vitae dolor sed purus tempus ullamcorper. Integer urna orci, lacinia ut ornare sit amet, luctus quis est. Ut interdum lorem in mattis lobortis. Maecenas tincidunt justo a lobortis facilisis.</p>
                <aside class="meta category-meta">
                    <div class="pull-left">
                        <div class="arc-comment"><a href="#" title="Comment"><i class="fa fa-comments"></i> 8 Comments</a></div>
                        <div class="arc-date">10/15/2016</div>
                    </div>
                    <div class="pull-right">
                        <ul class="arc-share">
                            <li><a href="#" title="Post"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-linkedin"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </aside>                                
            </div>
        </li>                        
    </ul>                    
</section>
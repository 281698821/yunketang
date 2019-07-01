<%--
  Created by IntelliJ IDEA.
  User: 28169
  Date: 2019/6/28
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Lithe</title>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
    <link href="css/font-awesome.min.css" rel="../../stylesheet">
    <link rel="stylesheet" type="text/css" href="../../style.css">
    <link rel="stylesheet" type="text/css" href="../../css/owl.carousel.css">
    <script src="jquery.quovolver.min.js"></script>
    <!--[if lt IE 9]-->
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <!--[endif]-->
    <!--[endif]-->
    <style type="text/css">
        #loginmain{
            margin-left: 1600px;
        }
    </style>
</head>

<body>
        <jsp:include page="../../header.jsp"></jsp:include>
        <!--banner starts-->
        <div class="banner-text">
            <div class="container">
                <div class="row">
                    <div class="banner-info text-center">
                        <h2><span class="grey">云课堂</span> - 学生自己的课堂</h2>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <!--banner ends-->
</header>
<!--header ends-->

<!--listing section-->
<section class="feature" id="listed">
    <div class="container">
        <div class="row">
            <div class="fea-head">
                <div class="col-md-12">
                    <div class="sec-head">
                        <h2><span>推荐课程</span></h2>
                        <hr></hr>
                    </div>
                </div>
                <div class="feature-slider col-md-12">
                    <div id="owl-demo">
                        <div class="item">
                            <div style="background-image: url(../../img/agent1.jpg); height: 150px ;width: 300px;">
                                <video controls="controls">
                                    <source src="../../videos/mytest.mp4" type="video/mp4"> 您的浏览器不支持此种视频格式。
                                </video>
                            </div>
                            <div class="img-info">
                                <h4>Best Deal Pre Sale</h4>
                            </div>
                        </div>
                        <div class="item">
                            <div style="background-image: url(../../img/agent1.jpg); height: 150px ;width: 300px;">
                                <video controls="controls">
                                    <source src="../../videos/mytest.mp4" type="video/mp4"> 您的浏览器不支持此种视频格式。
                                </video>
                            </div>
                            <div class="img-info">
                                <h4>Lithe Best Offer</h4>
                            </div>
                        </div>
                        <div class="item">
                            <div style="background-image: url(../../img/agent1.jpg); height: 150px ;width: 300px;">
                                <video controls="controls">
                                    <source src="../../videos/mytest.mp4" type="video/mp4"> 您的浏览器不支持此种视频格式。
                                </video>
                            </div>
                            <div class="img-info">
                                <h4>Las Vegas Residency</h4>
                            </div>
                        </div>
                        <div class="item">
                            <div style="background-image: url(../../img/agent1.jpg); height: 150px ;width: 300px;">
                                <video controls="controls">
                                    <source src="../../videos/mytest.mp4" type="video/mp4"> 您的浏览器不支持此种视频格式。
                                </video>
                            </div>
                            <div class="img-info">
                                <h4>New York Residency</h4>
                            </div>
                        </div>
                        <div class="item">
                            <div style="background-image: url(../../img/agent1.jpg); height: 150px ;width: 300px;">
                                <video controls="controls">
                                    <source src="../../videos/mytest.mp4" type="video/mp4"> 您的浏览器不支持此种视频格式。
                                </video>
                            </div>
                            <div class="img-info">
                                <h4>Seattle Residency</h4>
                            </div>
                        </div>
                        <div class="item">
                            <div style="background-image: url(../../img/agent1.jpg); height: 150px ;width: 300px;">
                                <video controls="controls">
                                    <source src="../../videos/mytest.mp4" type="video/mp4"> 您的浏览器不支持此种视频格式。
                                </video>
                            </div>
                            <div class="img-info">
                                <h4>South Carolina Residency</h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--agents section starts-->

<!--agents section starts-->
<section class="works" id="gallery">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="sec-head">
                    <h2<span>推荐课程</span>
                    </h2>
                    <hr></hr>
                </div>
            </div>
            <div class="work-sec">

                <div id="Container">
                    <div class="filimg mix category-1 category-3 col-md-4 col-sm-4 col-xs-12" data-myorder="2">
                        <div style="background-image: url(../../img/agent1.jpg); height: 150px ;width: 300px;">
                            <video src="../videos/mytest.mp4" controls="controls" ></video>
                        </div>
                        <div class="img-hover">
                            <h3>Resort</h3>
                        </div>
                    </div>
                    <div class="filimg mix category-1 category-3 col-md-4 col-sm-4 col-xs-12" data-myorder="2">
                        <div style="background-image: url(../../img/agent1.jpg); height: 150px ;width: 300px;">
                            <video src="../videos/mytest.mp4" controls="controls" ></video>
                        </div>
                        <div class="img-hover">
                            <h3>Resort</h3>
                        </div>
                    </div>
                    <div class="filimg mix category-1 category-3 col-md-4 col-sm-4 col-xs-12" data-myorder="2">
                        <div style="background-image: url(../../img/agent1.jpg); height: 150px ;width: 300px;">
                            <video src="../videos/mytest.mp4" controls="controls" ></video>
                        </div>
                        <div class="img-hover">
                            <h3>Resort</h3>
                        </div>
                    </div>
                    <div class="filimg mix category-1 category-3 col-md-4 col-sm-4 col-xs-12" data-myorder="2">
                        <div style="background-image: url(../../img/agent1.jpg); height: 150px ;width: 300px;">
                            <video src="../videos/mytest.mp4" controls="controls" ></video>
                        </div>
                        <div class="img-hover">
                            <h3>Resort</h3>
                        </div>
                    </div>
                    <div class="filimg mix category-2 col-md-4 col-sm-4 col-xs-12" data-myorder="4">
                        <div style="background-image: url(../../img/agent1.jpg); height: 150px ;width: 300px;">
                            <video controls="controls">
                                <source src="../videos/mytest.mp4" type="video/mp4"> 您的浏览器不支持此种视频格式。
                            </video>
                        </div>
                        <div class="img-hover">
                            <h3>Hotel</h3>
                        </div>
                    </div>
                    <div class="filimg mix category-1 col-md-4 col-sm-4 col-xs-12" data-myorder="1">
                        <div style="background-image: url(../../img/agent1.jpg); height: 150px ;width: 300px;">
                            <video controls="controls">
                                <source src="../videos/mytest.mp4" type="video/mp4"> 您的浏览器不支持此种视频格式。
                            </video>
                        </div>
                        <div class="img-hover">
                            <h3>Masion</h3>
                        </div>
                    </div>
                    <div class="filimg mix category-2 category-3 col-md-4 col-sm-4 col-xs-12" data-myorder="8">
                        <div style="background-image: url(../../img/agent1.jpg); height: 150px ;width: 300px;">
                            <video controls="controls">
                                <source src="../videos/mytest.mp4" type="video/mp4"> 您的浏览器不支持此种视频格式。
                            </video>
                        </div>
                        <div class="img-hover">
                            <h3>House</h3>
                        </div>
                    </div>
                    <div class="filimg mix category-2 col-md-4 col-sm-4 col-xs-12" data-myorder="8">
                        <div style="background-image: url(../../img/agent1.jpg); height: 150px ;width: 300px;">
                            <video controls="controls">
                                <source src="../videos/mytest.mp4" type="video/mp4"> 您的浏览器不支持此种视频格式。
                            </video>
                        </div>
                        <div class="img-hover">
                            <h3>Villa</h3>
                        </div>
                    </div>
                    <div class="filimg mix category-2 category-3 col-md-4 col-sm-4 col-xs-12" data-myorder="8">
                        <div style="background-image: url(../img/agent1.jpg); height: 150px ;width: 300px;">
                            <video controls="controls">
                                <source src="../videos/mytest.mp4" type="video/mp4"> 您的浏览器不支持此种视频格式。
                            </video>
                        </div>
                        <div class="img-hover">
                            <h3>School</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

        <jsp:include page="../../footer.jsp"></jsp:include>
<section class="footer-line" style="background-color: black;">
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <p>2015 &copy; All Rights Reserved. Designed By HTML5LAYOUTS using <a href="#">freedigitalphotos</a> and <a href="#">picjumbo</a> images</a> | <a href="#">Get Vector Graphics</a>
                    <br> More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
            </div>
        </div>
    </div>
</section>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/jquery-1.11.3.min.js"></script>
<script src="../../js/jquery-1.9.1.min.js"></script>
<script src="../../js/owl.carousel.js"></script>
<script src="../../js/jquery.mixitup.js" type="text/javascript"></script>
<script type="text/javascript" src="../../js/jquery.quovolver.js"></script>
<!--for smooth scrolling-->
<script>
    $(function() {
        $('a[href*=#]:not([href=#])').click(function() {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
    });
</script>
<!--demo-->
<script>
    $(document).ready(function() {
        $("#owl-demo").owlCarousel({
            autoPlay: 4000,
            items: 4,
            itemsDesktop: [1199, 3],
            itemsDesktopSmall: [979, 3]
        });
    });
</script>

<script type="text/javascript">
    $(document).ready(function() {
        var owl = $("#owl-demo");
        owl.owlCarousel();
        // Custom Navigation Events
        $(".next").click(function() {
            owl.trigger('owl.next');
        })
        $(".prev").click(function() {
            owl.trigger('owl.prev');
        })
    });
</script>

<script type="text/javascript">
    $(function() {
        // Instantiate MixItUp:
        $('#Container').mixItUp();
    });
</script>
<script>
    jQuery(function($) {
        // fancybox
        $(".fancybox").fancybox({
            modal: true, // disable regular nav and close buttons
            // add buttons helper (requires buttons helper js and css files)
            helpers: {
                buttons: {}
            }
        });
        // filter selector
        $(".filter").on("click", function() {
            var $this = $(this);
            // if we click the active tab, do nothing
            if (!$this.hasClass("active")) {
                $(".filter").removeClass("active");
                $this.addClass("active"); // set the active tab
                // get the data-rel value from selected tab and set as filter
                var $filter = $this.data("rel");
                // if we select view all, return to initial settings and show all
                $filter == 'all' ?
                    $(".fancybox")
                        .attr("data-fancybox-group", "gallery")
                        .not(":visible")
                        .fadeIn() : // otherwise
                    $(".fancybox")
                        .fadeOut(0)
                        .filter(function() {
                            // set data-filter value as the data-rel value of selected tab
                            return $(this).data("filter") == $filter;
                        })
                        // set data-fancybox-group and show filtered elements
                        .attr("data-fancybox-group", $filter)
                        .fadeIn(1000);
            } // if
        }); // on
    }); // ready
</script>
<!--texitimonial-->
<script>
    $('.quotes').quovolver({
        equalHeight: true
    });
</script>

</body>

</html>

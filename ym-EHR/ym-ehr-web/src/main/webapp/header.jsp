<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Lithe</title>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
          rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" type="text/css" href="css/owl.carousel.css">
    <!--[if lt IE 9]-->
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>


    <!--[endif]-->
    <style type="text/css">
        #loginmain {
            margin-left: 1500px;
        }
    </style>
</head>

<body>
<!--header starts-->
<div id="loginmain">


    <c:if test="${EMP_IN_SESSION.id!=null}">
        <img class="img-thumbnail" style="height:40px;width:40px" src="${EMP_IN_SESSION.img}">
        <span>&nbsp;欢迎你！${EMP_IN_SESSION.name}</span>
    </c:if>

    <c:if test="${EMP_IN_SESSION.id==null}">
        <button id="Login" class="btn btn-default" data-toggle="modal">
            登录
        </button>
        <button class="btn btn-default" data-toggle="modal">
            注册
        </button>
    </c:if>

</div>
<header class="main-header">
    <div class="backbg-color">
        <div class="navigation-bar">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <!--navigation starts-->
                        <nav class="navbar navbar-default">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse"
                                        data-target="#myNavbar">
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                                <a class="navbar-brand" href="#"><span class="black">武汉易思达科技有限公司</span></a>
                            </div>
                            <div class="collapse navbar-collapse navbar-right" id="myNavbar">
                                <ul class="nav navbar-nav">
                                    <li class="active"><a href="/index/index">首页</a></li>
                                    <li><a href="/index/video">视频</a></li>
                                    <li><a href="/index/team">班级</a></li>
                                    <li><a href="#gallery">考试</a></li>
                                    <li><a href="#news">资讯</a></li>
                                    <li><a href="#news">个人中心</a></li>
                                    <li><a href="#contact">更多</a></li>

                                </ul>

                            </div>

                        </nav>
                        <!--navigation ends-->

                    </div>

                </div>

            </div>

        </div>


        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-1.11.3.min.js"></script>
        <script src="js/jquery-1.9.1.min.js"></script>
        <script src="js/owl.carousel.js"></script>
        <script src="js/jquery.mixitup.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/jquery.quovolver.js"></script>
        <script src="js/login/login.js"></script>
        <script src="js/jquery.quovolver.min.js"></script>

        <!--for smooth scrolling-->
        <script>
            $(function () {
                $('a[href*=#]:not([href=#])').click(function () {
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
            $(document).ready(function () {
                $("#owl-demo").owlCarousel({
                    autoPlay: 4000,
                    items: 4,
                    itemsDesktop: [1199, 3],
                    itemsDesktopSmall: [979, 3]
                });
            });
        </script>

        <script type="text/javascript">
            $(document).ready(function () {
                var owl = $("#owl-demo");
                owl.owlCarousel();
                // Custom Navigation Events
                $(".next").click(function () {
                    owl.trigger('owl.next');
                })
                $(".prev").click(function () {
                    owl.trigger('owl.prev');
                })
            });
        </script>

        <script type="text/javascript">
            $(function () {
                // Instantiate MixItUp:
                $('#Container').mixItUp();
            });
        </script>
        <script>
            jQuery(function ($) {
                // fancybox


                // filter selector
                $(".filter").on("click", function () {
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
                                .filter(function () {
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
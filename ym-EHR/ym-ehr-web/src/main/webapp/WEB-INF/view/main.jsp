<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>layout 后台大布局 - Layui</title>
	<link rel="stylesheet" href="/lib/layui/css/layui.css">
	<link rel="stylesheet" type="text/css" href="/css/hp-layui.css" />
	<link rel="shortcut icon" href="favicon.ico" />
</head>

<body class="layui-layout-body hp-white-theme">
<div class="layui-layout layui-layout-admin">
	<div class="layui-header">
		<div class="layui-logo">
			云课堂后台管理系统
		</div>
		<!-- 头部区域（可配合layui已有的水平导航） -->
		<ul class="layui-nav layui-layout-left">
			<li class="hp-side-menu">
				<span><i class="layui-icon " >&#xe668;</i></span>
			</li>

		</ul>
		<ul class="layui-nav layui-layout-right">
			<li class="layui-nav-item">
				<a class="name" href="javascript:;"><i class="layui-icon"></i>主题<span class="layui-nav-more"></span></a>
				<dl class="layui-nav-child layui-anim layui-anim-upbit">
					<dd>
						<a skin="hp-black-theme" class="hp-theme-skin-switch"  href="javascript:;">低调黑</a>
					</dd>
					<dd >
						<a skin="hp-blue-theme" class="hp-theme-skin-switch" href="javascript:;">炫酷蓝</a>
					</dd>
					<dd>
						<a skin="hp-green-theme" class="hp-theme-skin-switch"  href="javascript:;">原谅绿</a>
					</dd>
				</dl>
			</li>
			<li class="layui-nav-item">
				<a href="/loginController/logout">退出</a>
			</li>
		</ul>
	</div>

	<div class="layui-side hp-left-menu">
		<div class="layui-side-scroll">
			<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
			<ul class="layui-nav hp-nav-none">
				<li class="layui-nav-item">
					<a href="javascript:;"  class="hp-user-name">
						<img src="${EMP_IN_SESSION.img}" class="layui-circle-img"><span class="hp-kd">${EMP_IN_SESSION.name}</span>
					</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl>
				</li>
			</ul>

			<ul class="layui-nav layui-nav-tree" lay-filter="test">

				<li class="layui-nav-item layui-nav-itemed">

					<a class="" href="javascript:;">
						<i class="layui-icon hp-icon-size">&#xe613;</i>组织机构管理</a>
					<dl class="layui-nav-child">
						<dd>

							<a class="hp-tab-add" hp-href="/companyController/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe7ae;</i> 公司管理
							</a>
						</dd>
						<dd>
							<a class="hp-tab-add" hp-href="/deptController/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe638;</i> 部门管理
							</a>
						</dd>

						<dd>
							<a class="hp-tab-add" hp-href="/positionController/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe66f;</i> 职位管理
							</a>
						</dd>
					</dl>
				</li>
				<li class="layui-nav-item layui-nav-itemed">

					<a class="" href="javascript:;">职员档案</a>
					<dl class="layui-nav-child">
						<dd>

							<a class="hp-tab-add" hp-href="/empController/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe662;</i> 员工信息管理
							</a>

						</dd>
						<dd>

							<a class="hp-tab-add" hp-href="/rewardPunishController/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe7ae;</i> 奖惩管理
							</a>
						</dd>

						<dd>
							<a class="hp-tab-add" hp-href="/departureController/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe638;</i> 离职员工信息管理
							</a>
						</dd>

					</dl>
				</li>

				<li class="layui-nav-item layui-nav-itemed">

					<a class="" href="javascript:;">薪资管理</a>
					<dl class="layui-nav-child">
						<dd>

							<a class="hp-tab-add" hp-href="/compensation/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe662;</i> 员工薪资表
							</a>

						</dd>
						<dd>

							<a class="hp-tab-add" hp-href="/paygrades/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe7ae;</i> 薪资等级管理
							</a>
						</dd>

						<dd>
							<a class="hp-tab-add" hp-href="/socialsecurity/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe638;</i> 社保管理
							</a>
						</dd>

						<dd>
							<a class="hp-tab-add" hp-href="/articlewages/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe638;</i> 工资条管理
							</a>
						</dd>

					</dl>
				</li>

				<li class="layui-nav-item layui-nav-itemed">

					<a class="" href="javascript:;">考勤管理</a>
					<dl class="layui-nav-child">
						<dd>

							<a class="hp-tab-add" hp-href="/attendance/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe662;</i> 考勤情况记载
							</a>

						</dd>
						<dd>

							<a class="hp-tab-add" hp-href="/rule/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe7ae;</i> 考勤规则
							</a>
						</dd>


					</dl>
				</li>

				<li class="layui-nav-item layui-nav-itemed">

					<a class="" href="javascript:;">招聘管理</a>
					<dl class="layui-nav-child">
						<dd>

							<a class="hp-tab-add" hp-href="/recruitmentdemandController/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe662;</i> 招聘需求管理
							</a>

						</dd>

						<dd>

							<a class="hp-tab-add" hp-href="/releasesController/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe662;</i> 信息发布管理
							</a>

						</dd>

						<dd>

							<a class="hp-tab-add" hp-href="/channelController/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe662;</i> 发布渠道管理
							</a>

						</dd>

						<dd>

							<a class="hp-tab-add" hp-href="/applicantController/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe662;</i> 应聘者管理
							</a>

						</dd>

						<dd>

							<a class="hp-tab-add" hp-href="/talentpoolController/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe662;</i> 人才储备管理
							</a>

						</dd>

					</dl>
				</li>

				<li class="layui-nav-item layui-nav-itemed">

					<a class="" href="javascript:;">团建管理</a>
					<dl class="layui-nav-child">
						<dd>

							<a class="hp-tab-add" hp-href="/activityController/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe62e;</i> 团建活动
							</a>

						</dd>
						<dd>

							<a class="hp-tab-add" hp-href="/holidayController/list" href="javascript:;">
								<i class="layui-icon hp-icon-size">&#xe637;</i> 节日祝福
							</a>

						</dd>

					</dl>
				</li>

			</ul>
		</div>
	</div>

	<div class="layui-body">
		<!-- 内容主体区域 -->
		<div class="layui-tab hp-tab " style="" lay-filter="hp-tab-filter" lay-allowclose="true">
			<ul class="layui-tab-title" style="">
				<li class="layui-this" lay-id="0">
					<i class="layui-icon hp-icon-size">&#xe68e;</i>首页
				</li>
			</ul>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<div class="layui-carousel" id="test1">
						<div carousel-item>
							<div style="background-image: url('/img/carouse/demo1.jpg')">
								<div style="text-align: center;margin-top:200px">
								</div>
							</div>

							<div style="background-image: url('/img/carouse/demo2.jpg')">
							</div>

							<div style="background-image: url('/img/carouse/demo3.jpg')">
							</div>

							<div style="background-image: url('/img/carouse/demo4.jpg')">
							</div>

						</div>
					</div>
					<!-- 源码地址 -->
					<div style="margin-top: 10px;">

						<blockquote class="layui-elem-quote">
							目标<br/>
							更高，更快，更强
						</blockquote>

						<blockquote class="layui-elem-quote">
							该站地址<br/>
							<a href="http://ub3szv.natappfree.cc"> http://ub3szv.natappfree.cc</a>
						</blockquote>

						<blockquote class="layui-elem-quote">
							<ul class="layui-nav layui-nav-tree" lay-filter="test">

								<li class="layui-nav-item layui-nav-itemed">

									<a class="" href="javascript:;">
										组织机构管理</a>
									<dl class="layui-nav-child">
										<dd>

											<a class="hp-tab-add" hp-href="/companyController/list" href="javascript:;">
												公司管理
											</a>
										</dd>
										<dd>
											<a class="hp-tab-add" hp-href="/deptController/list" href="javascript:;">
												 部门管理
											</a>
										</dd>

										<dd>
											<a class="hp-tab-add" hp-href="/positionController/list" href="javascript:;">
												职位管理
											</a>
										</dd>
									</dl>
								</li>
								<li class="layui-nav-item layui-nav-itemed">

									<a class="" href="javascript:;">职员档案</a>
									<dl class="layui-nav-child">
										<dd>

											<a class="hp-tab-add" hp-href="/empController/list" href="javascript:;">
												 员工信息管理
											</a>

										</dd>
										<dd>

											<a class="hp-tab-add" hp-href="/rewardPunishController/list" href="javascript:;">
												奖惩管理
											</a>
										</dd>

										<dd>
											<a class="hp-tab-add" hp-href="/departureController/list" href="javascript:;">
												离职员工信息管理
											</a>
										</dd>

									</dl>
								</li>

								<li class="layui-nav-item layui-nav-itemed">

									<a class="" href="javascript:;">薪资管理</a>
									<dl class="layui-nav-child">
										<dd>

											<a class="hp-tab-add" hp-href="/compensation/list" href="javascript:;">
												 员工薪资表
											</a>

										</dd>
										<dd>

											<a class="hp-tab-add" hp-href="/paygrades/list" href="javascript:;">
												 薪资等级管理
											</a>
										</dd>

										<dd>
											<a class="hp-tab-add" hp-href="/socialsecurity/list" href="javascript:;">
												 社保管理
											</a>
										</dd>

										<dd>
											<a class="hp-tab-add" hp-href="/articlewages/list" href="javascript:;">
												工资条管理
											</a>
										</dd>

									</dl>
								</li>

								<li class="layui-nav-item layui-nav-itemed">

									<a class="" href="javascript:;">考勤管理</a>
									<dl class="layui-nav-child">
										<dd>

											<a class="hp-tab-add" hp-href="/attendance/list" href="javascript:;">
												考勤情况记载
											</a>

										</dd>
										<dd>

											<a class="hp-tab-add" hp-href="/rule/list" href="javascript:;">
												 考勤规则
											</a>
										</dd>


									</dl>
								</li>

								<li class="layui-nav-item layui-nav-itemed">

									<a class="" href="javascript:;">招聘管理</a>
									<dl class="layui-nav-child">
										<dd>

											<a class="hp-tab-add" hp-href="/recruitmentdemandController/list" href="javascript:;">
												 招聘需求管理
											</a>

										</dd>

										<dd>

											<a class="hp-tab-add" hp-href="/releasesController/list" href="javascript:;">
												信息发布管理
											</a>

										</dd>

										<dd>

											<a class="hp-tab-add" hp-href="/channelController/list" href="javascript:;">
												 发布渠道管理
											</a>

										</dd>

										<dd>

											<a class="hp-tab-add" hp-href="/applicantController/list" href="javascript:;">
												<i class="layui-icon hp-icon-size">&#xe662;</i> 应聘者管理
											</a>

										</dd>

										<dd>

											<a class="hp-tab-add" hp-href="/talentpoolController/list" href="javascript:;">
											 人才储备管理
											</a>

										</dd>

									</dl>
								</li>

								<li class="layui-nav-item layui-nav-itemed">

									<a class="" href="javascript:;">团建管理</a>
									<dl class="layui-nav-child">
										<dd>

											<a class="hp-tab-add" hp-href="/activityController/list" href="javascript:;">
												团建活动
											</a>

										</dd>
										<dd>

											<a class="hp-tab-add" hp-href="/holidayController/list" href="javascript:;">
												 节日祝福
											</a>

										</dd>

									</dl>
								</li>

							</ul>
						</blockquote>

						<blockquote class="layui-elem-quote">
							扫描领取红包<br/>
							<img src="/img/weixin1.png">
						</blockquote>
					</div>


				</div>
			</div>

		</div>
	</div>

	<div class="layui-footer" style="text-align: center">
		© ehr管理系统-人力资源办公项目
	</div>
</div>
<script src="/lib/layui/layui.js"></script>
<script>
    // 配置
    layui.config({
        base: '/modules/' // 扩展模块目录
    }).extend({ // 模块别名
        hpIndex: 'admin/hpIndex',
        hpTab: 'hpComponent/hpTab',
        hpRightMenu: 'hpComponent/hpRightMenu',
        hpFormAll: 'hpComponent/hpFormAll',
        hpLayedit: 'hpComponent/hpLayedit',
        hpTheme: 'hpComponent/hpTheme'
    });
    //JavaScript代码区域
    layui.use(['element', 'carousel','hpTheme', 'hpTab', 'hpLayedit', 'hpRightMenu','hpIndex'], function() {
        var element = layui.element;
        var carousel = layui.carousel; //轮播
        var hpTab = layui.hpTab;
        var hpRightMenu = layui.hpRightMenu;
        var hpTheme=layui.hpTheme;
        var hpIndex = layui.hpIndex;
        $ = layui.jquery;
        // 初始化主题
        hpTheme.init();
        //初始化轮播
        carousel.render({
            elem: '#test1',
            width: '100%', //设置容器宽度
            interval: 1500,
            height: '500px',
            arrow: 'none', //不显示箭头
            anim: 'updown', //切换动画方式
        });

        // 初始化 动态tab
        hpTab.init();
        // 右键tab菜单
        hpRightMenu.init();
        // 主页公共js
        hpIndex.init();

    });
</script>
</body>

</html>
    
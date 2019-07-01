<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
layui.use([ 'hpTable', 'layer','form' ], function() {
    var table = layui.hpTable;
    var form=layui.form;
    var layer = layui.layer;
    var $ = layui.$;
    //方法级渲染
    var cmd= {
        fmt: {
            // 性别格式化
            paygrades: function (d) {
                var html = '';
                if (paygrades.id) {
                    html = d.paygrades.salary;
                }
                return html;
            }
        }
    };
    $.ajaxSettings.async = false;
    table.render({
        elem: '#kd-table',
        index:110,
        url: '/compensation/savePageAjaxList',
        singleSelect:true,// 扩展属性-单选
        cols: [
            [
                { checkbox:true,fixed: true,width: 80, align:'center'},
                { field: 'id', title: 'ID', width: 80, sort: true, fixed: true },
                { field: 'userid', title: '微信名', width: 160,fixed: true },
                { field: 'name', title: '用户名', width: 100, sort: true },
                { field: 'paygrades', width: 160, title: '基本薪资',templet:cmd.fmt.paygrades}
            ]
        ],
        page: true,
        height: 300,
        width:620,
    });

    var $ = layui.$,
        active = {
            reload: function() {
                var demoReload = $('#demoReload2');
                //执行重载
                table.reload('kd-table', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    },
                    where: {
                         name: demoReload.val()
                    }
                });
            },

        };
    $('.demoTable .layui-btn').on('click', function() {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
    /*//监听工具条
    table.on('tool(emp)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){
            layer.msg('ID：'+ data.id + ' 的查看操作');
        } else if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                layer.close(index);
            });
        } else if(obj.event === 'edit'){
            layer.alert('编辑行：<br>'+ JSON.stringify(data))
        }
    });*/

    //
//监听复选框选择
    /*  $(document).on("click",'.layui-form-checkbox',function(){
       //console.log(1);
       //$(this).parents('tr').siblings().find('.layui-form-checkbox').removeClass("layui-form-checked","")
       //
       var childs=$('input[name="layTableCheckbox"]');
             childs.each(function(i, item){
              item.checked =true;
            });
      });
      */

    //
    /*  table.on('checkbox(user)', function(obj){
          var _this=this;
          var idx=$(_this).parents('tr').data('index')
                 var childs=$('input[name="layTableCheckbox"]');
                 console.log(that)
                  console.log(obj)
                      console.log(table)
                      var thisData = table.cache['kd-table'];
                       console.log(thisData)
                       console.log($(_this).parents('tr').data('index'))
       /*      childs.each(function(i, item){
                 debugger
                 if(idx!=i){
                     item.checked =false;
                     //that.setCheckData(i, false);
                     //console.log($('.layui-table-view'))
                     //$('.layui-table-view')[0].setCheckData(i, false);
                     //$(item).siblings('.layui-form-checkbox').removeClass('layui-form-checked')
                 }

            });*/
    /*       $.each(thisData, function(i, item) {
               if(idx!=i){
               item['LAY_CHECKED'] =false;
               }
           });
                console.log(thisData)
             form.render("checkbox");


    });
    */

    /*table.on('checkbox(user)', function(obj){
      if (obj.type == "all") {
              var csss = $(".layui-table-cell.laytable-cell-1-0.laytable-cell-checkbox");
              csss.each(function(index, e){
                e.children[0].checked = false;
                e.children[1].className="layui-unselect layui-form-checkbox";
              });
      } else {
        var csss = $(".layui-table-cell.laytable-cell-1-0.laytable-cell-checkbox");
              csss.each(function(index, e){
                var dataIndex = e.parentNode.parentNode.getAttribute("data-index");
                if (dataIndex != null) {
                  if(dataIndex != obj.data.LAY_TABLE_INDEX){
                  e.children[0].checked = false;
                    e.children[1].className="layui-unselect layui-form-checkbox";
                  }
                } else {
                  e.children[0].checked = false;
                  e.children[1].className="layui-unselect layui-form-checkbox";
                }
              });
      }
    });*/
});

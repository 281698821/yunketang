layui.use(['hpTable','form'], function() {
    var table = layui.hpTable;

    table.render({
        elem: '#kd-table',
        index:110,
        url: '/empController/ajaxList',
        singleSelect:true,// 扩展属性-单选
        cols: [
            [
                { checkbox:true,fixed: true,width: 80, align:'center'},
                { field: 'id', title: 'ID', width: 80, sort: true, fixed: true },
                { field: 'name', title: '姓名', width: 80 },
                { field: 'sex', align: 'center', title: '性别'},
                { field: 'phone', align: 'center', title: '电话'},
                { fixed: 'right',  width: 180,toolbar: '#barDemo',title: '操作', align:'center' }
            ]
        ],
        page: true,
        height: 300,
        width:800,

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

        }

    $('.demoTable .layui-btn').on('click', function() {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    //监听工具条
    table.on('tool(user)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){
            layer.alert('ID：'+ data.id/*+'生日'+data.brithday+'当前地址'+data.currentAddress+'入职时间'+date.inductionTime*/);
        } else if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                layer.close(index);
            });
        }
    })


});
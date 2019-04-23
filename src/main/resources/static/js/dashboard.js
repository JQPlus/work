// var overview={
// 		 template: '#overview-template',
//          // created() {//生命周期钩子函数
//          //     console.log(this.$route.path);
//          // }
// }
// var problem={
//         //props定义一个组件属性
//         props: ['mydata'],
//         template: '#problem-template'
// }
// var statistics={
//     template: '#statistics-template'
// }
// var about={
//     template: '#about-template',
// }

var router = new VueRouter({
    routes: [
        // path 表示监听路由地址
        // component组件模板-> 如果path是正确的路由地址，那就就展示路径所对应的组件模板样式
        //这里通过router和<router-view>组件来实现，其实后面定义的component组件中的template都是被<router-view>封装
        // 这里使用了重定向redirect
        {
            path: '/',
            redirect: '/overview',
        },
        {
            path: '/overview',
            component: {
                template: '#overview-template',
                // created() {//生命周期钩子函数
                //     console.log(this.$route.path);
                // }
            }
            // component:overview,
        },
        {
            path: '/problem',
            component: {
                //props定义一个组件属性
                props: ['mydata'],
                template: '#problem-template'
            }
            // component:problem,
        }, {
            path: '/statistics',
            component: {
                template: '#statistics-template'
            }
            // component:statistics
        },
        {
            path: '/about',
            component: {
                template: '#about-template'
            }
            // component:about
        },
    ]
})

const tableItem = {
    date: '2016-05-02',
    name: '王小虎',
    address: '上海市普陀区金沙江路 1518 弄',
    status: '新建',
    priority: '致命',
    belongto: '1' + 'to' + '2',
};

//dashboard-vue实例
var dashboard = new Vue({
    el: "#dashboard-template",
    router,
    methods: {
        statusDropdownChoose,
        priorityDropdownChoose,
        filterHandler,
        tableDbEdit(row, column, cell, event) {//编辑单元格数据
            //当鼠标双击单元格里面具体单元格的时候，即可对数据进行编辑操作，其实就是添加了一个输入框，最终将输入框中的数据保存下来就行了。
            event.target.innerHTML = "";
            let cellInput = document.createElement("input");
            cellInput.value = "";
            cellInput.setAttribute("type", "text");
            cellInput.style.width = "60%";
            cell.appendChild(cellInput);
            cellInput.onblur = function () {
                cell.removeChild(cellInput);
                event.target.innerHTML = cellInput.value;
            };
        }
    },
    data: {

        // search: '',
        /*tableData: Array(20).fill(tableItem),*/
        tableData: [{
            date: '2016-05-01',
            name: '王小虎1',
            address: '上海市普陀区金沙江路 1511 弄',
            status: '新建',
            priority: '致命',
            belongto: '1' + 'to' + '2',
        }, {
            date: '2016-05-02',
            name: '王小虎2',
            address: '上海市普陀区金沙江路 1512 弄',
            status: '处理中',
            priority: '严重',
            belongto: '2' + 'to' + '3',
        }, {
            date: '2016-05-03',
            name: '王小虎3',
            address: '上海市普陀区金沙江路 1513 弄',
            status: '已拒绝',
            priority: '一般',
            belongto: '3' + 'to' + '4',
        }, {
            date: '2016-05-04',
            name: '王小虎4',
            address: '上海市普陀区金沙江路 1514 弄',
            status: '已验收',
            priority: '轻微',
            belongto: '4' + 'to' + '5',
        },
        {
            date: '2016-05-05',
            name: '王小虎5',
            address: '上海市普陀区金沙江路 1515 弄',
            status: '已解决',
            priority: '一般',
            belongto: '5' + 'to' + '6',
        }]
    }
})
//状态数组
var statusDropdown = [
    { text: '新建', value: '新建' },
    { text: '处理中', value: '处理中' },
    { text: '已拒绝', value: '已拒绝' },
    { text: '已验收', value: '已验收' },
    { text: '已解决', value: '已解决' },
]
//将command（状态）值赋给表中数据
function statusDropdownChoose(command) {
    console.log(command)
}

//优先级数组
var priorityDropdown = [
    { text: '致命' },
    { text: '严重' },
    { text: '一般' },
    { text: '轻微' },
]
//将command（优先级）值赋给表中数据
function priorityDropdownChoose(command) {
    console.log(command)
}

function filterHandler(value, row, column) {
    const property = column['property'];
    return row[property] === value;
}


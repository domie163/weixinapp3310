const base = {
    get() {
        return {
            url : "http://localhost:8080/zhanguishejigongsipingmianbuzhi/",
            name: "zhanguishejigongsipingmianbuzhi",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/zhanguishejigongsipingmianbuzhi/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "展柜设计公司平面布置小程序"
        } 
    }
}
export default base









const menu = {
    list() {
        return [
    {
        "backMenu":[
        ],
        "frontMenu":[
        ],
        "hasBackLogin":"是",
        "hasBackRegister":"否",
        "hasFrontLogin":"否",
        "hasFrontRegister":"否",
        "roleName":"管理员",
        "tableName":"users"
    },
    {
        "backMenu":[
			{
                "child":[
                    {
                        "buttons":[
                            "查看"
                        ],
                        "menu":"收货地址信息",
                        "menuJump":"列表",
                        "tableName":"address"
                    }
                ],
                "menu":"收货地址信息"
            }
			,
			{
                "child":[
                    {
                        "buttons":[
                            "查看"
                        ],
                        "menu":"展柜设计信息",
                        "menuJump":"列表",
                        "tableName":"goods"
                    }
                ],
                "menu":"展柜设计信息"
            }
			,
			{
                "child":[
                    {
                        "buttons":[
                            "查看"
                        ],
                        "menu":"公告信息",
                        "menuJump":"列表",
                        "tableName":"news"
                    }
                ],
                "menu":"公告信息"
            }
        ],
        "frontMenu":[
        ],
        "hasBackLogin":"是",
        "hasBackRegister":"否",
        "hasFrontLogin":"是",
        "hasFrontRegister":"是",
        "roleName":"用户",
        "tableName":"yonghu"
    }
]

	}
}
export default menu;

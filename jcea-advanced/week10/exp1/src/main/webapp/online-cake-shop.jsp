<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>网上蛋糕店</title>
</head>

<body>
    <div>
        <input type="button" value="查询蛋糕信息" onclick="refreshCakeTable()">
    </div>
    <table id="cakeTable"></table>
    <div>
        <h2>请选择您需要购买的蛋糕</h2>
        <div>
            <label><input type="checkbox" name="buyCakeCheck" value="1">缤纷年华</label>
        </div>
        <div>
            <label><input type="checkbox" name="buyCakeCheck" value="2">甜蜜物语</label>
        </div>
        <div>
            <label><input type="checkbox" name="buyCakeCheck" value="3">娜爱丝甜品</label>
        </div>
        <div>
            <label><input type="checkbox" name="buyCakeCheck" value="4">朵莎</label>
        </div>
        <div>
            <input type="button" value="确定购买" onclick="buyCake()">
        </div>
        <h2>您购买的蛋糕有</h2>
        <table id='buyCakeTable'></table>
        <div>
            总价格&emsp;<span id='priceSum'></span>
        </div>
    </div>
    <script type="text/javascript" src="./js/axios.min.js"></script>
    <script type="text/javascript">
        let cakeTableTitle = '<tr>' +
            '<th>' + '编号' + '</th>' +
            '<th>' + '蛋糕名称' + '</th>' +
            '<th>' + '价格' + '</th>' +
            '<th>' + '数量' + '</th>' +
            '</tr>';
        function refreshCakeTable() {
            axios
                .post('http://localhost:8080/BuyCakeServlet', null)
                .then((resp) => {
                    let cakeList = resp.data['cakeList'];
                    let cakeTable = cakeTableTitle;
                    for (let i = 0; i < cakeList.length; i++) {
                        let cake = cakeList[i];
                        cakeTable += '<tr>' +
                            '<th>' + cake.id + '</th>' +
                            '<th>' + cake.name + '</th>' +
                            '<th>' + cake.price + '</th>' +
                            '<th>' + cake.number + '</th>' +
                            '</tr>';
                    }
                    document.getElementById('cakeTable').innerHTML = cakeTable;
                });
        }
        let buyRecord = [
            [0, 0],
            [0, '缤纷年华', 12.8],
            [0, '甜蜜物语', 18.8],
            [0, '娜爱丝甜品', 9.9],
            [0, '朵莎', 15.8]
        ];
        function buyCake() {
            let buyCakeCheckList = document.getElementsByName('buyCakeCheck');
            let buyCakeIdList = [];
            for (let i = 0; i < buyCakeCheckList.length; i++) {
                if (buyCakeCheckList[i].checked === true) {
                    buyCakeIdList.push(buyCakeCheckList[i].value);
                    buyRecord[buyCakeCheckList[i].value][0]++;
                }
            }
            axios
                .post(
                    'http://localhost:8080/BuyCakeServlet',
                    {
                        data: {
                            buyCakeIdList: buyCakeIdList
                        }
                    }
                )
                .then((resp) => {
                    refreshCakeTable();
                    let buyCakeTable = cakeTableTitle;
                    let priceSum = 0.0;
                    for (let i = 1; i <= 4; i++) {
                        if (buyRecord[i][0] > 0) {
                            let curPriceSum = buyRecord[i][0] * buyRecord[i][2];
                            buyCakeTable += '<tr>' +
                                '<th>' + i + '</th>' +
                                '<th>' + buyRecord[i][1] + '</th>' +
                                '<th>' + buyRecord[i][0] + '</th>' +
                                '<th>' + curPriceSum + '</th>' +
                                '</tr>';
                            priceSum += curPriceSum;
                        }
                    }
                    document.getElementById('buyCakeTable').innerHTML = buyCakeTable;
                    document.getElementById('priceSum').innerHTML = priceSum;
                });
        }
    </script>
</body>
</html>
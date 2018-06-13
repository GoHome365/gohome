//document.write("<script language=javascript src='js/layer/layer.js’></script>");


function takeBus(radio) {
    vehicle = radio.value;
    loadWorkLocation()
}

function takeSubway(radio) {
    vehicle = radio.value;
    loadWorkLocation()
}

//2 取工作地点名称信息
function workLocationSelected(e) {

   // workAddress = e.poi.name;//丽海花园
    loadWorkLocation();
}


//3 解析work地点并设置1小时范围
function loadWorkLocation() {
    delWorkLocation();
    //加载地理编码插件
    var geocoder = new AMap.Geocoder({
        city: "北京",//城市，默认："全国"
        radius: 1000 //以已知坐标为中心点，radius为半径，返回范围内兴趣点和道路信息
    });

    //根据名称查找定位
    geocoder.getLocation(workAddress, function (status, result) {
        if (status === "complete" && result.info === 'OK') {
            var geocode = result.geocodes[0];
            x = geocode.location.getLng();//解析工作地点坐标
            y = geocode.location.getLat();
            loadWorkMarker(x, y, workAddress);//标记工作地点
            loadWorkRange(x, y, 60, "#3f67a5", vehicle);//标记工作范围
            map.setZoomAndCenter(12, [x, y]);//地图缩放至指定级别并以指定点为地图显示中心点
        }
    })
}


//4加载房源信息
function loadFyInfo() {

    getRentLocation();
}


function getRentLocation() {
    delRentLocation();
    var rent_locations = new Set();
    var cityName = "北京";
    var rspData ;

    $.ajax({
        async: false,
        type: "post",
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        url: "/community/getCommunity",
        data: JSON.stringify({ 'city': cityName }),
        success: function (dataList) {
            rspData = dataList;
        },
        error: function () {
            alert('Error' + rspData);
        },
        complete: function () {
        }
    });

    rspData.forEach(function (item, index) {
        rent_locations.add(item.adress);
    });
    rent_locations.forEach(function (element, index) {
        addMarkerByAddress(element);
    });

}

//3.1标记工作地点
function loadWorkMarker(x, y, locationName) {
    workMarker = new AMap.Marker({
        map: map,
        title: locationName,
        icon: 'http://webapi.amap.com/theme/v1.3/markers/n/mark_r.png',
        position: [x, y]

    });
}

//3.2标记工作地点一小时到达地区
function loadWorkRange(x, y, t, color, v) {
    arrivalRange.search([x, y], 60, function (status, result) {
        if (result.bounds) {//bounds返回到达圈边界坐标点
            for (var i = 0; i < result.bounds.length; i++) {
                var polygon = new AMap.Polygon({
                    map: map,
                    fillColor: color,
                    fillOpacity: "0.4",
                    strokeColor: color,
                    strokeOpacity: "0.8",
                    strokeWeight: 1
                });
                polygon.setPath(result.bounds[i]);
                polygonArray.push(polygon);
            }
        }
    }, {
        policy: v
    });
}

//6 标记房源地址
function addMarkerByAddress(address) {
    var geocoder = new AMap.Geocoder({
        city: "北京",
        radius: 1000
    });
    //根据名称查找定位
    geocoder.getLocation(address, function (status, result) {
        if (status === "complete" && result.info === 'OK') {
            var geocode = result.geocodes[0];
            rentMarker = new AMap.Marker({
                map: map,
                title: address,
                icon: '/image/mark_b.png',
                position: [geocode.location.getLng(), geocode.location.getLat()]
            });
            rentMarkerArray.push(rentMarker);

            //http://bj.58.com/pinpaigongyu/  北京地区58地址
            rentMarker.content = "<div>房源：<a target = '_blank' href='http://bj.58.com/pinpaigongyu/?key=" + address + "'>" + address + "</a><div>"
            rentMarker.on('click', function (e) {
                infoWindow.setContent(e.target.content);
                infoWindow.open(map, e.target.getPosition());
                if (amapTransfer) amapTransfer.clear();
                amapTransfer = new AMap.Transfer({
                    map: map,
                    policy: AMap.TransferPolicy.LEAST_TIME,
                    city: "北京市",
                    panel: 'transfer-panel'
                });
                amapTransfer.search([{
                    keyword: workAddress
                }, {
                    keyword: address
                }], function (status, result) {
                })
            });
        }
    })
}

function delWorkLocation() {
    if (polygonArray) map.remove(polygonArray);
    if (workMarker) map.remove(workMarker);
    polygonArray = [];
}

function delRentLocation() {
    if (rentMarkerArray) map.remove(rentMarkerArray);
    rentMarkerArray = [];
}

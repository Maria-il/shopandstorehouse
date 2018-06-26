var rootURL = "http://localhost:8080/shopandstorehouse/rest/garments";

var currentGarment;

findAll();

$('#btnMoveToStorehouse').click(function () {
    moveToStoreHouse();
    return false;
});

$('#btnMoveToShop').click(function () {
    moveToShop();
    return false;
});


$('#btnAddToStorehouse').click(function () {
    addGarmentToStoreHouse();
    return false;
});

$('#btnAddToShop').click(function () {
    addGarmentToShop();
    return false;
});

$('#btnSave').click(function () {
    if ($('#garmentId').val() == '')
        addGarmentToStoreHouse();
    else
        updateGarment();
    return false;
});

$('#btnDelete').click(function () {
    deleteGarment();
    return false;
});

$('#shopList').on('click', 'li a', function () {
    findById($(this).data('identity'));
});

$('#storehouseList').on('click', 'li a', function () {
    findById($(this).data('identity'));
});

function findById(id) {
    console.log('findById: ' + id);
    $.ajax({
        type: 'GET',
        url: rootURL + '/find/' + id,
        dataType: "json",
        success: function (data) {
            console.log('findById success: ' + data.name);
            currentGarment = data;
            renderDetails(currentGarment);
        }
    });
}

function renderDetails(garment) {
    $('#garmentId').val(garment.id);
    $('#size').val(garment.size);
    $('#price').val(garment.price);
    $('#color').val(garment.color);
    $('#type').val(garment.type);
    $('#description').val(garment.description);
}

function renderEmpty() {
    $('#garmentId').val(0);
    $('#size').val('');
    $('#price').val('');
    $('#color').val('');
    $('#type').val('');
    $('#description').val('');
}

function deleteGarment() {
    $.ajax({
        type: 'GET',
        url: rootURL + '/delete/' + $('#garmentId').val(),
        success: function (data, textStatus, jqXHR) {
            console.log('Garment deleted successfully');
            renderEmpty();
            findAll();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('deleteGarment error');
        }
    });
}

function updateGarment() {
    var check = checkForm();
    if (check) {
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: rootURL + '/update',
            dataType: "json",
            data: formToJSON(),
            success: function (data, textStatus, jqXHR) {
                console.log('Garment updated successfully');
                renderEmpty();
                findAll();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('updateGarment error: ' + textStatus);
            }
        });
    } else {
        console.log('updateGarment error');
    }
}

function moveToStoreHouse() {
    $.ajax({
        type: 'GET',
        contentType: 'application/json',
        url: rootURL + '/movetostorehouse/' + $('#garmentId').val(),
        success: function (data, textStatus, jqXHR) {
            console.log('Garment added successfully');
            $('#garmentId').val();
            renderEmpty();
            findAll();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('addGarment error: ' + textStatus);
        }
    });
}

function moveToShop() {
    $.ajax({
        type: 'GET',
        contentType: 'application/json',
        url: rootURL + '/movetoshop/' + $('#garmentId').val(),
        success: function (data, textStatus, jqXHR) {
            console.log('Garment added successfully');
            $('#garmentId').val();
            renderEmpty();
            findAll();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('addGarment error: ' + textStatus);
        }
    });
}

function addGarmentToStoreHouse() {
    var check = checkForm();
    if (check) {
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: rootURL + '/addtostorehouse',
            dataType: "json",
            data: formToJSON(),
            success: function (data, textStatus, jqXHR) {
                console.log('Garment added successfully');
                $('#garmentId').val(data.id);
                renderEmpty();
                findAll();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('addGarment error: ' + textStatus);
            }
        });
    } else {
        console.log('addGarment error');
    }
}

function addGarmentToShop() {
    var check = checkForm();
    if (check) {
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: rootURL + '/addtoshop',
            dataType: "json",
            data: formToJSON(),
            success: function (data, textStatus, jqXHR) {
                console.log('Garment added successfully');
                $('#garmentId').val(data.id);
                renderEmpty();
                findAll();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('addGarment error: ' + textStatus);
            }
        });
    }else{
        console.log('addGarment error');
    }
}

function findAll() {
    $.ajax({
        type: 'GET',
        url: rootURL + '/getshopgarments',
        dataType: "json",
        success: renderShopList
    });
    $.ajax({
        type: 'GET',
        url: rootURL + '/getstorehousegarments',
        dataType: "json",
        success: renderStorehouseList
    });
}

function renderShopList(data) {
    var list = data == null ? [] : (data instanceof Array ? data : [data]);

    $('#shopList li').remove();
    $.each(list, function (index, garment) {
        $('#shopList').append('<li><a href="#" data-identity="' + garment.id + '">' + garment.description + '</a></li>');
    });
}

function renderStorehouseList(data) {
    var list = data == null ? [] : (data instanceof Array ? data : [data]);

    $('#storehouseList li').remove();
    $.each(list, function (index, garment) {
        $('#storehouseList').append('<li><a href="#" data-identity="' + garment.id + '">' + garment.description + '</a></li>');
    });
}

function checkForm() {
    return $('#size').val() !== '' && $('#price').val() !== ''
        && $('#color').val() !== '' && $('#type').val() !== ''
        && $('#description').val() !== '';
}

function formToJSON() {
    return JSON.stringify({
        "id": $('#garmentId').val() == '' ? '0' : $('#garmentId').val(),
        "size": $('#size').val(),
        "price": $('#price').val(),
        "color": $('#color').val(),
        "type": $('#type').val(),
        "description": $('#description').val()
    });
}

function getValue(array, fieldName) {
    return array.find(el => el.field === fieldName).value
}


function sendForm(e) {
    const nodes = e.parentElement.getElementsByTagName("input")
    const isInvoice = e.parentElement.getElementsByTagName("select").isInvoice.value
    const values = Array.from(nodes).map(el => {
        return {
            field: el.name,
            value: el.value
        }
    })
    fetch("transactions/addTransaction", {
            headers: {
                'Content-Type': 'application/json'
            },
            method: 'POST',
            mode: 'cors',
            body: JSON.stringify({
                "books": Storage.getCart(),
                "client": {
                    "companyName": getValue(values, 'companyName'),
                    "email": getValue(values, 'email'),
                    "id": "",
                    "name": getValue(values, 'firstname'),
                    "nip": getValue(values, 'nip'),
                    "surname": getValue(values, 'surname')
                },
                "id": "string",
                "invoice": isInvoice,
                "price":Storage.getPrice()
            })
        })
        .then(response => response.json())
        .then(json => console.log(json))
}
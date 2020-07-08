import { Province, sampleProvinceData } from './province.js';

let province = new Province(sampleProvinceData());

const htmlTemplate = `
<h2>지역: ${province.name}</h2>
<div>
    <label for="demand">수요:</label>
    <input name="demand" type="text" value="${province.demand}">
    <label for="price">가격:</label>
    <input name="price" type="text" value="${province.price}">
</div>
<p>생산자 수: ${province.producers.length}</p>
<div>
    <div>
        <label for="name">${province.producers[0].name}:</label>    
        <label for="cost">비용: </label>
        <input name="cost" type="text" value="${province.producers[0].cost}">
        <label for="production">생산량: </label>
        <input name="production" type="text" value="${
            province.producers[0].production
        }">
        <label for="profit">수익: </label>
        <input name="profit" type="text" value="${
            (province.price - province.producers[0].cost) *
            province.producers[0].production
        }">
    </div>
    <div>
        <label for="name">${province.producers[1].name}:</label>    
        <label for="cost">비용: </label>
        <input name="cost" type="text" value="${province.producers[1].cost}">
        <label for="production">생산량: </label>
        <input name="production" type="text" value="${
            province.producers[1].production
        }">
        <label for="profit">수익: </label>
        <input name="profit" type="text" value="${
            (province.price - province.producers[1].cost) *
            province.producers[1].production
        }">
    </div>
    <div>
        <label for="name">${province.producers[2].name}:</label>    
        <label for="cost">비용: </label>
        <input name="cost" type="text" value="${province.producers[2].cost}">
        <label for="production">생산량: </label>
        <input name="production" type="text" value="${
            province.producers[2].production
        }">
        <label for="profit">수익: </label>
        <input name="profit" type="text" value="${
            (province.price - province.producers[2].cost) *
            province.producers[2].production
        }">
    </div>
</div>
<p>부족분: <strong>${province.shortfall}</strong>\t총수익: <strong>${
    province.profit
}</strong></p>
`;
document.body.innerHTML = htmlTemplate;

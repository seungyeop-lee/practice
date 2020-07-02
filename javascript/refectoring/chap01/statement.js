import fs from "fs";
import createStatementData from "./createStatementData";

// 공연료 청구서 출력 함수
function statement(invoice, plays) {
    return renderPlainText(createStatementData(invoice, plays));
}

function renderPlainText(data) {
    let result = `청구 내역 (고객명: ${data.customer})\n`;
    for (let perf of data.performances) {
        // 청구 내역을 출력한다.
        result += `  ${perf.play.name}: ${usd(perf.amount)} (${perf.audience}석)\n`;
    }

    result += `총액: ${usd(data.totalAmount)}\n`;
    result += `적립 포인트: ${data.totalVolumeCredits}점\n`;
    return result;
}

function htmlStatement(invoice, plays) {
    return renderHtml(createStatementData(invoice, plays));
}

function renderHtml(data) {
    let result = `<h1>청구 내역 (고객명: ${data.customer})</h1>\n`;
    result += "<table>\n";
    result += "  <tr><th>연극</th><th>좌석 수</th><th>금액</th></tr>\n";
    for (let perf of data.performances) {
        result += `  <tr><td>${perf.play.name}</td><td>(${perf.audience}석)</td>`;
        result += `<td>${usd(perf.amount)}</td></tr>\n`;
    }
    result += "</table>\n";
    result += `<p>총액: <em>${usd(data.totalAmount)}</em></p>\n`;
    result += `<p>적립 포인트: <em>${data.totalVolumeCredits}</em>점</p>\n`;
    return result;
}

function usd(aNumber) {
    return new Intl.NumberFormat("en-US",
        {style: "currency", currency: "USD", minimumFractionDigits: 2}).format(aNumber / 100);
}

let invoicesRawData = fs.readFileSync('invoices.json');
let invoices = JSON.parse(invoicesRawData);
let playsRawData = fs.readFileSync('plays.json');
let plays = JSON.parse(playsRawData);

const plainExpected = `청구 내역 (고객명: BigCo)
  Hamlet: $650.00 (55석)
  As You Like It: $580.00 (35석)
  Othello: $500.00 (40석)
총액: $1,730.00
적립 포인트: 47점
`;

const plainResult = statement(invoices[0], plays);
console.log("statement() test result: ", plainResult === plainExpected);

const htmlExpected = `<h1>청구 내역 (고객명: BigCo)</h1>
<table>
  <tr><th>연극</th><th>좌석 수</th><th>금액</th></tr>
  <tr><td>Hamlet</td><td>(55석)</td><td>$650.00</td></tr>
  <tr><td>As You Like It</td><td>(35석)</td><td>$580.00</td></tr>
  <tr><td>Othello</td><td>(40석)</td><td>$500.00</td></tr>
</table>
<p>총액: <em>$1,730.00</em></p>
<p>적립 포인트: <em>47</em>점</p>
`;

const htmlResult = htmlStatement(invoices[0], plays);
console.log("htmlStatement() test result: ", htmlResult === htmlExpected);

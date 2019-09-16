package part1.chap7.verse4

import javax.swing.JButton
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

// 자바의 이벤트 리스너 등록
JButton button = new JButton("자바입니다. 누르세요!");
button.addActionListener(new ActionListener() {
    @Override
    void actionPerformed(ActionEvent e) {
        System.out.println(button.getText());
    }
});

button.doClick()    // 자바입니다. 누르세요!

// 그루비의 이벤트 리스너 등록
button = new JButton('그루비입니다. 누르세요!')
// 콜백 메소드의 이름을 프로퍼티로 등록
button.actionPerformed = { event ->
    println button.text
}

button.doClick()    // 그루비입니다. 누르세요!
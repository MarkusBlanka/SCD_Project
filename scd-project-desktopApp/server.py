from flask import Flask, request, jsonify
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

inbox = []

@app.route('/sendemail', methods=['POST'])
def send_email():
    data = request.get_json()
    inbox.append(data)
    return jsonify({'message': 'Email sent successfully'}), 200

@app.route('/inbox', methods=['GET'])
def get_inbox():
    return jsonify(inbox)

if __name__ == '__main__':
    app.run(port=5000)

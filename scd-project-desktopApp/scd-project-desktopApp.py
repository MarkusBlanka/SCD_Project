import tkinter as tk
from tkinter import ttk, messagebox
import requests

class MyApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Management Viewer")
        root.geometry("500x350")

        self.department_var = tk.StringVar()
        self.department_dropdown = ttk.Combobox(self.root, textvariable=self.department_var, state="readonly")
        self.department_dropdown.pack(pady=10)

        fetch_department_button = tk.Button(self.root, text="Fetch Departments", command=self.fetch_departments)
        fetch_department_button.pack(pady=10)

        self.employee_var = tk.StringVar()
        self.employee_dropdown = ttk.Combobox(self.root, textvariable=self.employee_var, state="readonly")
        self.employee_dropdown.pack(pady=10)

        fetch_employee_button = tk.Button(self.root, text="Fetch Employees", command=self.fetch_employees)
        fetch_employee_button.pack(pady=10)

        inbox_button = tk.Button(self.root, text="Inbox", command=self.show_inbox)
        inbox_button.pack(pady=10)

    def fetch_departments(self):
        api_url = "http://localhost:8080/api/departments"
        response = requests.get(api_url)

        if response.status_code == 200:
            departments = response.json()
            self.department_dropdown["values"] = [department["departmentName"] for department in departments]
        else:
            print(f"Failed to fetch departments. Status code: {response.status_code}")

    def fetch_employees(self):
        api_url = "http://localhost:8080/api/employees"
        response = requests.get(api_url)

        if response.status_code == 200:
            employees = response.json()
            self.employee_dropdown["values"] = [employee["firstName"] for employee in employees]
        else:
            print(f"Failed to fetch employees. Status code: {response.status_code}")

    def show_inbox(self):
        # Fetch emails from the server and display in a messagebox
        try:
            response = requests.get("http://localhost:5000/inbox")
            emails = response.json()

            inbox_text = ""
            for email in emails:
                inbox_text += f"To: {email['employee']}\nSubject: {email['subject']}\nMessage: {email['message']}\n\n"

            if inbox_text:
                messagebox.showinfo("Inbox", inbox_text)
            else:
                messagebox.showinfo("Inbox", "No emails in the inbox.")

        except Exception as e:
            messagebox.showerror("Error", f"Failed to fetch inbox. Error: {str(e)}")

if __name__ == "__main__":
    root = tk.Tk()
    app = MyApp(root)
    root.mainloop()

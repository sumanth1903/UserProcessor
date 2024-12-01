
# 🐳 Docker Installation and Running a Docker Compose File

This guide provides instructions to:
1. 🚀 Install Docker on macOS and Windows.
2. 📂 Run a Docker Compose file after installation.

---

## 📖 Table of Contents
- [Installing Docker on macOS](#installing-docker-on-macos)
- [Installing Docker on Windows](#installing-docker-on-windows)
- [Verify Installation](#verify-installation)
- [Running a Docker Compose File](#running-a-docker-compose-file)
- [🛠️ Troubleshooting](#️troubleshooting)

---

## Installing Docker on macOS 🍎

### 🔧 Command-Line Installation
1. **Install Homebrew (if not installed):**
   ```bash
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   ```

2. **Install Docker:**
   ```bash
   brew install --cask docker
   ```

3. **Start Docker Desktop:**
   Open Docker from the `Applications` folder or run:
   ```bash
   open /Applications/Docker.app
   ```

4. **Verify Installation:**
   ```bash
   docker --version
   ```

---

## Installing Docker on Windows 🪟

### 🔧 Command-Line Installation
1. **Download Docker Desktop Installer:**
   Open PowerShell or Command Prompt:
   ```powershell
   Invoke-WebRequest -Uri "https://desktop.docker.com/win/stable/Docker%20Desktop%20Installer.exe" -OutFile "DockerDesktopInstaller.exe"
   ```

2. **Run the Installer:**
   ```powershell
   Start-Process -FilePath ".\DockerDesktopInstaller.exe" -Wait
   ```

3. **Enable WSL 2 (If Required):**
   If Docker prompts to enable WSL 2:
   ```powershell
   wsl --install
   ```

4. **Launch Docker Desktop:**
   Start Docker from the Start Menu or via:
   ```powershell
   start docker
   ```

5. **Verify Installation:**
   ```powershell
   docker --version
   ```

---

## 🔍 Verify Installation
After installing Docker:
1. Check Docker version:
   ```bash
   docker --version
   ```
2. Check Docker Compose version:
   ```bash
   docker-compose --version
   ```

---

## 📂 Running a Docker Compose File

### Step 1: Navigate to the Directory
Use the terminal to navigate to the directory where your `docker-compose.yml` file is located. For example:
```bash
cd /path/to/docker-compose-file
```

---

### Step 2: Run the Docker Compose File
Run the following command to start the services defined in the Docker Compose file:
```bash
docker-compose up
```

- **To run in detached mode** (in the background):
  ```bash
  docker-compose up -d
  ```

---

### Step 3: Stop and Clean Up
To stop and remove all containers defined in the compose file:
```bash
docker-compose down
```

---

### 🔍 Verify Running Services
Check the status of running containers:
```bash
docker ps
```


---

## 🛠️ Troubleshooting
- **Docker Daemon Not Running**: Ensure Docker Desktop is running before using `docker` commands.
- **Permission Issues**:
    - On macOS, you may need to use `sudo` for certain commands.
    - On Windows, run the terminal as Administrator.
- **Service Issues**: Check logs for more details:
  ```bash
  docker-compose logs
  ```

---

You're all set! 🎉

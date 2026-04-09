# H2 Database Configuration Guide

## ✅ What is H2?

**H2 is an embedded database** that:
- Requires NO installation or setup
- Stores data in a file (`./data/workshopdb.mv.db`)
- Works perfectly with Spring Boot
- Zero configuration needed!

---

## 🚀 How to Use

### Option 1: H2 (Recommended - No Setup!)
**Default configuration - uses H2 embedded database**

```bash
cd workshop-backend
mvn spring-boot:run
```

Data is saved in: `./data/workshopdb.mv.db`

**Access H2 Console** (optional):
- URL: http://localhost:8081/h2-console
- JDBC URL: `jdbc:h2:file:./data/workshopdb`
- Username: `sa`
- Password: (leave empty)

### Option 2: MySQL (Local)
**If you want to use local MySQL instead:**

```bash
cd workshop-backend
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=mysql"
```

Or set environment variable:
```bash
SET SPRING_PROFILES_ACTIVE=mysql
mvn spring-boot:run
```

---

## 📁 Configuration Files

| File | Purpose |
|------|---------|
| `application.properties` | **Default - H2 database** |
| `application-h2.properties` | H2 profile configuration |
| `application-mysql.properties` | MySQL profile configuration |

---

## 🔄 Switch Between Databases

### Switch to MySQL (Local)
1. Ensure MySQL is running locally
2. Run backend with MySQL profile:
   ```bash
   mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=mysql"
   ```

### Switch Back to H2
1. Just run normally (H2 is default):
   ```bash
   mvn spring-boot:run
   ```

---

## ☁️ For Render Deployment

H2 works great on Render! 

**Just deploy as-is** - No environment variables needed!

The database file (`./data/workshopdb.mv.db`) will be:
- Created automatically
- Persisted in Render's storage
- Available across restarts

---

## 📊 Data Persistence

### Local Machine (Development)
- Data saved in: `./data/workshopdb.mv.db`
- Survives application restarts
- All users share same database

### Render (Production)
- Data saved in Render's ephemeral storage
- **Note**: Data may be lost if service is destroyed
- For critical data, consider external MySQL

---

## 🔧 Troubleshooting

### "Cannot connect to database"
- H2 doesn't need to be running separately
- If error persists, check logs with: `mvn spring-boot:run`

### "Database file locked"
- Another instance is using the same file
- Ensure only one backend is running

### Switch from H2 to MySQL mid-project
1. Export H2 data (SQL file)
2. Create MySQL database
3. Import SQL file into MySQL
4. Switch profile to `mysql`

---

## 📌 API Testing

Your API works the same regardless of database:

```bash
# Test backend is running
curl http://localhost:8081/api/workshops

# Register user
curl -X POST http://localhost:8081/api/registrations \
  -H "Content-Type: application/json" \
  -d '{"email":"user@example.com","password":"Test123"}'
```

---

## ✨ Benefits of H2

✅ **Zero Setup** - No MySQL installation needed  
✅ **File-Based** - Data saved locally  
✅ **Fast** - In-memory + file-backed  
✅ **Perfect for Learning** - Great for development  
✅ **Easy to Deploy** - Works on Render  
✅ **Web Console** - Visualize data via web interface  

---

## 🎯 Recommended Setup

**For Development (Local):**
- Use **H2** (default) or MySQL depending on preference
- Data saved locally in `./data/workshopdb.mv.db`

**For Testing:**
- Use **H2** with test profile

**For Render Deployment:**
- Use **H2** (simplest)
- Or use external MySQL/cloud database for persistence

---

**All set! Your backend now uses H2 by default.** 🚀
